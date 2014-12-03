package com.bonvio.project2.dao.cafe.waiters.implementation;

import com.bonvio.project2.classes.cafe.waiters.CafeWaiterObject;
import com.bonvio.project2.classes.cafe.waiters.NamedPositionWithQuantity;
import com.bonvio.project2.classes.cafe.waiters.Order;
import com.bonvio.project2.classes.cafe.waiters.extractors.OrdersWithTableNamesDBExtractor;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.cafe.waiters.CafeWaitersPagesDao;
import org.springframework.jdbc.core.RowMapper;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Arti on 02.07.2014.
 */
public class CafeWaitersPagesDaoImpl extends BaseDao implements CafeWaitersPagesDao {

    public CafeWaitersPagesDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public int checkWaiterCredentials(String optimizedNumber, String password) {
        return 1;
    }

    /*public int getUserUnitAccessRights(int wsId, String unitCode, String userId) {
        //two different queries for personal or corporal desktops
        Integer ret;
        String q;
        try {
            if (wsId == 0) {
                q = "select count(*) from " + defaultSchema + ".s_u_ws ws " +
                        "left join " + defaultSchema + ".S_U_WS_APPS apps " +
                        "on ws.S_ID=apps.S_WS_ID " +
                        "left join " + defaultSchema + ".S_WS_APPS p " +
                        "on apps.S_APP_ID=p.s_id " +
                        "where " +
                        "apps.S_WS_ID=?" +
                        "and p.S_NAME=? " +
                        "and ws.S_PHONENUMBER=?";
                System.out.println(q);
                return getJdbcTemplate().queryForInt(q, wsId, unitCode, userId);
            } else {
                q = "select count(*) from " + defaultSchema + ".s_u_ws ws " +
                        "left join " + defaultSchema + ".S_U_WS_APPS apps " +
                        "on ws.S_ID=apps.S_WS_ID " +
                        "left join " + defaultSchema + ".S_WS_APPS p " +
                        "on apps.S_APP_ID=p.s_id " +
                        "where " +
                        "apps.S_WS_ID=?" +
                        "and p.S_NAME=? " +
                        "and ws.S_PHONENUMBER=?";
                System.out.println(q);
                return getJdbcTemplate().queryForInt(q, wsId, unitCode, userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }*/

    public ArrayList<OrdersWithTableNamesDBExtractor> getCafeWaiterObjectInfo(String ip) {
        CafeWaiterObject c = new CafeWaiterObject();
        String q = "select s_name, s_capacity from "+defaultSchema+".s_cafe_spot_sectors where s_ip=?";
        c = getJdbcTemplate().queryForObject(q, new RowMapper<CafeWaiterObject>() {
            @Override
            public CafeWaiterObject mapRow(ResultSet resultSet, int i) throws SQLException {
                return new CafeWaiterObject(
                        resultSet.getInt(2),
                        resultSet.getString(1),
                        null
                );
            }
        }, ip);
        HashMap<Integer, ArrayList<NamedPositionWithQuantity>> map = new HashMap<Integer, ArrayList<NamedPositionWithQuantity>>();
        ArrayList<OrdersWithTableNamesDBExtractor> extList = new ArrayList<OrdersWithTableNamesDBExtractor>();
        q = "select  " +
                "O.S_ID, " +
                "O.S_TABLE_NUM, " +
                "O.S_DATE_OPEN, " +
                "P.S_DATE, " +
                "P.S_POSITION_ID, " +
                "P.S_QUANT, " +
                "M.S_NAME, " +
                "M.S_PRICE, " +
                "P.s_status, " +
                "P.S_ID " +
                "from  " +
                defaultSchema+".S_CAFE_ORDERS O " +
                "left join " +
                defaultSchema+".S_CAFE_ORDER_POSITIONS P " +
                "on O.S_ID=P.S_ORDER_ID " +
                "where O.S_IP=?  and NOT(P.S_POSITION_ID is null) and O.S_DATE_CLOSE is null " +
                "group by O.S_ID, O.S_TABLE_NUM, O.S_TABLE_NUM, P.S_POSITION_ID, P.s_status, P.S_QUANT, O.S_DATE_OPEN, P.S_DATE, M.S_NAME, M.S_PRICE, P.S_ID  " +
                "order by O.S_ID";
        extList.addAll(getJdbcTemplate().query(q, new RowMapper<OrdersWithTableNamesDBExtractor>() {
            @Override
            public OrdersWithTableNamesDBExtractor mapRow(ResultSet r, int i) throws SQLException {
                return new OrdersWithTableNamesDBExtractor(
                        r.getInt(10),
                        r.getInt(2),
                        r.getInt(1),
                        r.getInt(5),
                        r.getString(7),
                        r.getDouble(6),
                        r.getTimestamp(4),
                        r.getInt(9)
                );
            }
        }, ip));
//        ArrayList<NamedPositionWithQuantity> npwq = new ArrayList<NamedPositionWithQuantity>();
        return extList;
    }

    public int changeState(int orderId, int positionId, int newState) {
        try {
            String q = "update "+defaultSchema+".S_CAFE_ORDER_POSITIONS " +
                    "set s_status=? " +
                    "where s_order_id=? and S_POSITION_ID=? and (s_status=1 or s_status=0)";
            getJdbcTemplate().update(q, newState, orderId, positionId);
            return 1;
        } catch (Exception e) {

            return 0;
        }
    }

    public int addPosition(int orderId, int positionId, int newQuantity) {
        try {
            String q = "insert into "+defaultSchema+".S_CAFE_ORDER_POSITIONS " +
                    "(s_order_id, s_position_id, s_status, s_quant, s_date) " +
                    "values (?,?,0,?,SYSDATE)";
            getJdbcTemplate().update(q, orderId, positionId, newQuantity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int changePositionQuantity(int orderId, int positionId, int newQuantity) {
        try {
            String q = "update "+defaultSchema+".S_CAFE_ORDER_POSITIONS " +
                    "set S_QUANTITY=? " +
                    "where s_order_id=? and S_POSITION_ID=? and (s_status <> 2)";
            getJdbcTemplate().update(q, newQuantity, orderId, positionId);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int removePosition(int orderId, int positionId) {
        try {
            String q = "delete from "+defaultSchema+".S_CAFE_ORDER_POSITIONS " +
                    "where s_order_id=? and S_POSITION_ID=?";
            getJdbcTemplate().update(q, orderId, positionId);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int clientTableChange(int oldTable, int newTable) {
        try {
            String q= "update "+defaultSchema+".s_orders set s_table_num=? where s_table_num=?";
            getJdbcTemplate().update(q, newTable, oldTable);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<Integer> getFreeTablesArray(String ip) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(getJdbcTemplate().query("select distinct O.S_TABLE_NUM from "+defaultSchema+".s_cafe_orders O where s_date_close is null and O.S_DATE_OPEN>SYSDATE-1 and O.S_DATE_OPEN<SYSDATE+10/1440",
                new RowMapper<Integer>() {
                    @Override
                    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                        return resultSet.getInt(1);
                    }
                }));
        Integer capacity = getJdbcTemplate().queryForInt("select s_capacity from "+defaultSchema+".s_cafe_spot_sectors where s_ip=?", ip);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=1; i<=capacity; i++) {
            if(!list.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public int getUserUnitAccessRights(int wsId, String unitCode, String userId) {
        String q;
        try {
            q = "select count(*) from ( " +
                    "select " +
                    "gws.S_ID, gws.S_WS_NAME, APPS.S_NAME, APPS.S_CODE, APPS.S_APP_ADDRESS from "+defaultSchema+".s_g_ws gws " +
                    "left join "+defaultSchema+".S_G_WS_APPS ga " +
                    "on " +
                    "gws.S_ID=ga.S_GWS_ID " +
                    "left join "+defaultSchema+".S_WS_APPS APPS " +
                    "on " +
                    "ga.S_APP_ID=APPS.S_ID " +
                    "left join "+defaultSchema+".s_users U " +
                    "on " +
                    "U.S_ID=gws.S_USER_ID " +
                    "where " +
                    "GWS.S_ID=? and APPS.S_CODE=? and U.S_ID=? " +
                    "group by " +
                    "gws.s_id, gws.S_WS_NAME, APPS.S_NAME, APPS.S_CODE, APPS.S_APP_ADDRESS)";
            return (getJdbcTemplate().queryForInt(q, userId, wsId, unitCode)>0) ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

















