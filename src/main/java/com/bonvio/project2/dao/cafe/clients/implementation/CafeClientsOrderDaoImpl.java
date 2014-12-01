package com.bonvio.project2.dao.cafe.clients.implementation;

import com.bonvio.project2.classes.cafe.waiters.internal.InternalEvent;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.cafe.clients.OrderDao;
import com.bonvio.project2.classes.cafe.clients.PositionWithQuantity;
import com.bonvio.project2.dao.cafe.events.implementation.CafeEventsDaoImpl;
import com.bonvio.project2.classes.cafe.events.MenuPositionWithQuantity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Arti on 19.06.2014.
 */
public class CafeClientsOrderDaoImpl extends BaseDao implements OrderDao {

    @Autowired
    public CafeClientsOrderDaoImpl(DataSource dataSource) {super(dataSource);}
    @Autowired
    private CafeEventsDaoImpl eventsDao;


    public int addOrder(String jsonPosID, Date date, HttpServletRequest request) {
        try {
            CafeEventsDaoImpl eventsDao = new CafeEventsDaoImpl(this.getDataSource());
            HttpSession session = request.getSession();
            Integer tableNum = (Integer)session.getAttribute("userTableNum");
            ArrayList<PositionWithQuantity> pwqList = new ArrayList<PositionWithQuantity>();
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray)((JSONObject)parser.parse(jsonPosID)).get("orderPositions");
//            Integer spotId = 10000;
            for(int i=0; i< array.size();i++) {
                JSONObject j = (JSONObject)array.get(i);
                Integer k = Integer.parseInt(j.get("positionId").toString());
                pwqList.add(new PositionWithQuantity(
                    k,
                    getPositionNameByPositionId(k),
                    Double.parseDouble(j.get("positionQuantity").toString()))
                );
            }
            String eventBody = "";
            for(PositionWithQuantity e: pwqList) {
                eventBody += e.getPositionName()+"\t"+e.getPositionQuantity()+"\n";
            }
            String userid = (((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession()).getAttribute("cafeUserPhoneNumber").toString();
            int orderId;
            try {
                orderId = getJdbcTemplate().queryForInt("select max(s_id) from " + defaultSchema + ".s_cafe_orders where s_client_id=? and s_table_num=? and s_date_close is null", userid, tableNum);
                if(orderId<1) {
                    getJdbcTemplate().update("insert into "+defaultSchema+".s_cafe_orders (s_client_id, s_table_num, s_ip) values (?,?,?)", userid, tableNum, request.getRemoteAddr());
                }
            } catch (Exception e) {
                getJdbcTemplate().update("insert into " + defaultSchema + ".s_cafe_orders (s_client_id, s_table_num, s_ip) values (?,?,?)", userid, tableNum, request.getRemoteAddr());
            }
            orderId = getJdbcTemplate().queryForInt("select max(s_id) from "+defaultSchema+".s_cafe_orders where s_client_id=? and s_date_close is null", userid);
            for(PositionWithQuantity pwq: pwqList) {
                getJdbcTemplate().update("insert into "+defaultSchema+".s_cafe_order_positions (s_order_id, s_position_id, s_status, s_quant, s_date) values (?,?,?,?, ?)", orderId, pwq.getPositionId(), 0, pwq.getPositionQuantity(), new Date());
            }
            Integer spotId = eventsDao.getSpotIdBySpotIpAddress(request.getRemoteAddr());
            eventsDao.putEvent(new InternalEvent(
                    0,
                    null,
                    11,
                    1,
                    tableNum+"",
                    eventBody,
                    spotId,
                    0,
                    0,
                    orderId
            ), spotId);
            return orderId;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* public int addPosition(String order, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            Integer tableNum = (Integer)session.getAttribute("cafeUserTableNum");
            ArrayList<PositionWithQuantity> pwqList = new ArrayList<PositionWithQuantity>();
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray)((JSONObject)parser.parse(order)).get("orderPositions");
            for(int i=0; i< array.size();i++) {
                JSONObject j = (JSONObject)array.get(i);
                pwqList.add(new PositionWithQuantity(
                                Long.parseLong(j.get("positionId").toString()),
                                Double.parseDouble(j.get("positionQuantity").toString()))
                );
            }
            String userid = (((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession()).getAttribute("cafeUserPhoneNum").toString();
            ArrayList<Integer> iList = new ArrayList<Integer>();
            iList.addAll(getJdbcTemplate().query("select max(s_id) from "+defaultSchema+".s_cafe_orders where s_client_id=?", new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                    return resultSet.getInt(1);
                }
            }, userid));
            Integer orderId = iList.get(0);
            for(PositionWithQuantity pwq: pwqList) {
                getJdbcTemplate().update("insert into "+defaultSchema+".s_cafe_order_positions (s_order_id, s_position_id, s_status, s_quant, s_date) values (?,?,?,?, ?)", orderId, pwq.getPositionId(), 0, pwq.getPositionQuantity(), new Date());
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    */

    public ArrayList<MenuPositionWithQuantity> getPositionsWithStatus(int orderId) {
        try {
            ArrayList<MenuPositionWithQuantity> positions = new ArrayList<>();
            String userid = (((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession()).getAttribute("cafeUserPhoneNumber").toString(),
                    q = "select " +
                        "  MUP.S_ID as S_ID, " +
                        "  L.S_NAME as S_LANG_NAME, " +
                        "  MUP.S_NAME as S_POS_NAME, " +
                        "  MUP.S_PRICE as S_PRICE, " +
                        "  MUP.S_DESCRIPTION as S_DESCRIPTION, " +
                        "  MUP.S_QUANTITY as S_QUANTITY," +
                        "  MUP.S_UNITS as S_UNITS," +
                        "  MUP.S_RECIPE as S_RECIPE," +
                        "  OP.s_status as S_STATUS, " +
                        "  MUP.s_included as S_INCLUDED, " +
                        "  MU.S_TYPE as S_TYPE, "+ //JOIN TABLES WITH MENUUNITS
                        "  OP.s_QUANT as S_QUANT " +
                        "from "+defaultSchema+".S_CAFE_ORDER_POSITIONS OP " +
                        "left join "+defaultSchema+".S_CAFE_ORDERS O " +
                        "on O.S_ID=OP.S_ORDER_ID " +
                        "left join "+defaultSchema+".S_CAFE_MENU_UNITS_POSITIONS MUP " +
                        "on MUP.S_ID=OP.S_POSITION_ID " +
                        "left join "+defaultSchema+".S_UTIL_LANGUAGES L " +
                        "on L.S_ID=MUP.S_LANGUAGE_ID " +
                            "left join "+defaultSchema+".s_cafe_positions_by_categories PBC " +
                            "on PBC.S_POSITION_ID=MUP.S_ID " +
                            "left join "+defaultSchema+".s_cafe_menu_units MU " +
                            "on MU.S_ID=PBC.S_CATEGORY_ID " +
//                        "where O.S_ID=? and O.S_CLIENT_ID=? and O.S_DATE_CLOSE is null " +
                        "where O.S_ID=? and O.S_CLIENT_ID=? " +
                        "order by OP.S_DATE";
            positions.addAll(
                    getJdbcTemplate().query(q, new RowMapper<MenuPositionWithQuantity>() {
                        @Override
                        public MenuPositionWithQuantity mapRow(ResultSet r, int i) throws SQLException {
                            return new MenuPositionWithQuantity(
                                    r.getLong(1),
                                    r.getString(2),
                                    r.getString(3),
                                    r.getDouble(4),
                                    r.getString(5),
                                    r.getDouble(6),
                                    r.getString(7),
                                    r.getString(8),
                                    r.getInt(9),
                                    r.getInt(10),
                                    r.getInt(11),
                                    r.getInt(12)
                            );
                        }
                    }, orderId, userid)
            );
            return positions;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int setPositionRefusedByClient(int orderId, int positionId) {
        try {
            Integer i = getJdbcTemplate().queryForInt("select count(*) from "+defaultSchema+".s_cafe_order_positions where s_order_id=? and s_id=? and s_status<3", orderId, positionId);
            if(i > 0) {
                getJdbcTemplate().update("update "+defaultSchema+".s_cafe_orders set s_status=2 where s_order_id="+orderId+" and  and s_id="+positionId);
            } else
                return 2;
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int closeOrder(int tblNum, int orderId, String ip) {
        try {
            getJdbcTemplate().update("update "+defaultSchema+".s_cafe_orders set s_date_close=CURRENT_TIMESTAMP where s_table_num=?", tblNum);
            int spotId = eventsDao.getSpotIdBySpotIpAddress(ip);
            Integer i = getJdbcTemplate().queryForInt(
                "SELECT " +
                    "TRUNC(SUM(POS.S_QUANT*MUP.S_PRICE)) " +
                    "FROM " + defaultSchema + ".s_cafe_orders ORD " +
                    "LEFT JOIN " + defaultSchema + ".s_cafe_order_positions POS " +
                    "ON ORD.S_ID=POS.S_ORDER_ID " +
                    "LEFT JOIN " + defaultSchema + ".S_CAFE_MENU_UNITS_POSITIONS MUP " +
                    "ON POS.S_POSITION_ID=MUP.S_ID " +
                    "WHERE ORD.S_TABLE_NUM=?",
            tblNum);
            eventsDao.putEvent(new InternalEvent(
                    0,
                    null,
                    13,
                    1,
                    tblNum+"",
                    "Принести счёт на ~"+i+" рублей.",
                    spotId,
                    0,
                    0,
                    orderId
            ), spotId);
            return i;
        } catch (Exception e) {
            System.out.println("Ошибка закрытия заказа");
            e.printStackTrace();
            return 0;
        }
    }

    public String getPositionNameByPositionId(int positionId) {
        try {
            ArrayList<String> sList = new ArrayList<>();
            sList.addAll(getJdbcTemplate().query("select s_name from " + defaultSchema + ".s_cafe_menu_units_positions where s_id=?", new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet resultSet, int i) throws SQLException {
                    return resultSet.getString(1);
                }
            }, positionId));
            return sList.get(0);
        } catch (Exception e) {
            System.out.println("Ошибка получения названия позиции по ID позиции: ошибка синтаксиса Oracle");
            e.printStackTrace();
            return null;
        }
    }
}
