package com.bonvio.project2.dao.cafe.waiters.implementation;

import com.bonvio.project2.classes.cafe.clients.MenuPosition;
import com.bonvio.project2.classes.cafe.clients.PositionWithQuantity;
import com.bonvio.project2.classes.cafe.waiters.FullMenuDBExtractor;
import com.bonvio.project2.classes.cafe.waiters.internal.InternalEvent;
import com.bonvio.project2.classes.cafe.waiters.internal.OrderForWaiter;
import com.bonvio.project2.classes.common.menuupload.MenuCategory;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.cafe.events.implementation.CafeEventsDaoImpl;
import com.bonvio.project2.dao.cafe.waiters.CafeWaitersOrdersDao;
import org.apache.commons.io.IOUtils;
import org.hibernate.type.descriptor.BinaryStream;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.LobRetrievalFailureException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Arti on 28.07.14.
 */
public class CafeWaitersOrdersDaoImpl extends BaseDao implements CafeWaitersOrdersDao {

    @Autowired
    public CafeWaitersOrdersDaoImpl(DataSource dataSource) {
        super(dataSource);
    }
    @Autowired
    public CafeEventsDaoImpl eventsDao;

    
    public List<OrderForWaiter> getOrders() {
        List<OrderForWaiter> oList = new LinkedList<>();
        try {
            String q =
                    "select " +
                            "ORD.S_ID, " +
                            "ORD.S_DATE_OPEN, " +
                            "ORD.S_DATE_CLOSE, " +
                            "ORD.S_TABLE_NUM, " +
                            "OP.S_POSITION_ID, " +
                            "OP.S_ID, " +
                            "UP.S_NAME, " +
                            "OP.S_QUANT, " +
                            "OP.S_STATUS " +
                            "from " +
                            defaultSchema + ".s_cafe_orders ORD " +
                            "left join " +
                            defaultSchema + ".S_CAFE_ORDER_POSITIONS OP " +
                            "on " +
                            "ORD.S_ID=OP.S_ORDER_ID " +
                            "left join " +
                            defaultSchema + ".S_CAFE_MENU_UNITS_POSITIONS UP " +
                            "on " +
                            "OP.S_POSITION_ID=UP.S_ID " +
                            "order by ORD.S_ID, OP.S_DATE";
            oList.addAll(getJdbcTemplate().query(q, new RowMapper<OrderForWaiter>() {
                
                public OrderForWaiter mapRow(ResultSet r, int i) throws SQLException {
                    return new OrderForWaiter(
                            r.getInt(1),
                            r.getTimestamp(2),
                            r.getTimestamp(3),
                            r.getInt(4),
                            r.getInt(5),
                            r.getInt(6),
                            r.getString(7),
                            r.getDouble(8),
                            r.getInt(9)
                    );
                }
            }));
            System.out.println(oList);
            return oList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public LinkedList<OrderForWaiter> getOrderByOrderId(int orderId) {
        try {
            LinkedList<OrderForWaiter> ofwList = new LinkedList<OrderForWaiter>();
            String q =
                    "select " +
                            "ORD.S_ID, " +
                            "ORD.S_DATE_OPEN, " +
                            "ORD.S_DATE_CLOSE, " +
                            "ORD.S_TABLE_NUM, " +
                            "OP.S_POSITION_ID, " +
                            "OP.S_ID, " +
                            "UPOS.S_NAME, " +
                            "OP.S_QUANT, " +
                            "OP.S_STATUS " +
                            "from " + defaultSchema + ".s_cafe_orders ORD " +
                            "left join " + defaultSchema + ".S_CAFE_ORDER_POSITIONS OP on ORD.S_ID=OP.S_ORDER_ID " +
                            "left join " + defaultSchema + ".S_CAFE_MENU_UNITS_POSITIONS UPOS on OP.S_POSITION_ID=UPOS.S_ID " +
                            "where ORD.S_ID=? "+
                            "order by OP.S_DATE";
            ofwList.addAll(getJdbcTemplate().query(q, new RowMapper<OrderForWaiter>() {
                
                public OrderForWaiter mapRow(ResultSet r, int i) throws SQLException {
                    return new OrderForWaiter(
                            r.getInt(1),
                            r.getTimestamp(2),
                            r.getTimestamp(3),
                            r.getInt(4),
                            r.getInt(5),
                            r.getInt(6),
                            r.getString(7),
                            r.getDouble(8),
                            r.getInt(9)
                    );
                }
            }, orderId));
            System.out.println(ofwList);
            return ofwList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public int closeOrderByOrderId(int orderId) {
        try {
            String q = "update "+defaultSchema+".s_cafe_orders set s_date_close=CURRENT_TIMESTAMP where s_id="+orderId;
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    
    public int changePositionStatus(int orderId, int s_id, int positionId, int newStatus) {
        try {
            String q = "update "+defaultSchema+".s_cafe_orders set s_status=1 where s_order_id="+orderId+" and s_positionId="+positionId+" and s_id="+s_id;
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    
    public int addPositionToOrder(int orderId, int positionId, int addedQuant) {
        try {
            String q = "insert into "+defaultSchema+".s_cafe_order_positions " +
                    "(" +
                        "s_order_id, " +
                        "s_position_id, " +
                        "s_status, " +
                        "s_quant, " +
                        "s_date" +
                    ") " +
                    "values (?,?,?,SYSDATE)";
            getJdbcTemplate().update(q, orderId, positionId, addedQuant);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    
    public int removePositionFromOrder(int orderId, int positionInMenuId, int positionInOrderId) {
        try {
            String q = "delete from "+defaultSchema+".s_cafe_order_positions where s_id="+orderId;
            getJdbcTemplate().update(q);


            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    
    public int resizeOrderPosition(int orderId, int positionInMenuId, int positionId, int newQuant) {
        try {
            String q = "update "+defaultSchema+".s_cafe_order_positions set s_quant="+newQuant+" where s_id="+positionId+" and s_order_id="+orderId;
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int statusSetClientRefused(int orderId, int positionId) {
        try {
            getJdbcTemplate().update("update "+defaultSchema+".s_cafe_orders set s_status=2 where s_order_id="+orderId+" and  and s_id="+positionId);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int statusSetReady(int orderId, int positionId) {
        try {
            String q = "update "+defaultSchema+".s_cafe_orders set s_status=5 where s_order_id="+orderId+" and s_id="+positionId;
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int statusSetAccomplished(int orderId, int positionId, String ipAddress) {
        try {
            String q = "update "+defaultSchema+".s_cafe_order_positions set s_status=6 where s_order_id="+orderId+" and s_id="+positionId;
            getJdbcTemplate().update(q);
            Integer spotId = getSpotIdBySpotIpAddress(ipAddress);
            eventsDao.putEvent(
                new InternalEvent(
                        0,
                        null,
                        26,
                        1,
                        getTableNumByOrderId(orderId)  + " стол: позиция доставлена официантом",
                        "Позиция '"+"'",
                        spotId,
                        0,
                        0,
                        orderId
                ),
                spotId
            );
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public Integer getSpotIdBySpotIpAddress(String remoteAddr) {
        try {
            return getJdbcTemplate().queryForInt("select s_cafe_spot_id from "+defaultSchema+".s_cafe_spot_sectors where s_ip=?", remoteAddr);
        } catch (Exception e) {
            System.out.println("Ошибка получения ID сектора по его IP-адресу: ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public String getPositionNameByPositionId(int positionId) {
        try {
            ArrayList<String> sList = new ArrayList<>();
            sList.addAll(getJdbcTemplate().query("select s_name from " + defaultSchema + ".s_cafe_menu_units_positions where s_id=?", new RowMapper<String>() {
                
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

    public Integer getTableNumByOrderId(Integer orderId) {
        try {
            return getJdbcTemplate().queryForInt("select s_table_num from "+defaultSchema+".s_cafe_orders where s_id=?", orderId);
        } catch (Exception e) {
            System.out.println("Ошибка получения номера стола по номеру заказа: ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }

//    public Map<MenuCategory, LinkedList<MenuPosition>> getMenu(String remoteAddr) {
    public LinkedList<FullMenuDBExtractor> getMenu(String remoteAddr) {
        try {
            Map<MenuCategory, LinkedList<MenuPosition>> map = new HashMap<MenuCategory, LinkedList<MenuPosition>>();
            LinkedList<MenuPosition> mpList = new LinkedList<>();
            LinkedList<FullMenuDBExtractor> e = new LinkedList<>();
            String q = "SELECT " +
                    "MU.S_ID,  " +
                    "MU.S_NAME,  " +
                    "MU.S_CODE,  " +
                    "MUP.S_ID,  " +
                    "LANG.S_NAME,  " +
                    "MUP.S_NAME,  " +
                    "MUP.S_PRICE,  " +
                    "MUP.S_DESCRIPTION,  " +
                    "MUP.S_PICTURE,  " +
                    "MUP.S_QUANTITY,  " +
                    "MUP.S_UNITS,  " +
                    "MUP.S_RECIPE,  " +
                    "0,  " +
                    "MUP.S_INCLUDED " +
                    "FROM "+defaultSchema+".S_CAFE_SPOTS SPOTS " +
                    "LEFT JOIN "+defaultSchema+".S_CAFE_SPOT_SECTORS SECTORS " +
                    "ON SPOTS.S_ID=SECTORS.S_CAFE_SPOT_ID " +
                    "LEFT JOIN "+defaultSchema+".S_CAFE_MENU_UNITS MU " +
                    "ON MU.S_CAFE_SECTOR_ID=SECTORS.S_ID " +
                    "LEFT JOIN "+defaultSchema+".S_CAFE_POSITIONS_BY_CATEGORIES PBC " +
                    "ON MU.S_ID=PBC.S_CATEGORY_ID " +
                    "LEFT JOIN "+defaultSchema+".S_CAFE_MENU_UNITS_POSITIONS MUP " +
                    "ON MUP.S_ID=PBC.S_POSITION_ID " +
                    "LEFT JOIN "+defaultSchema+".S_UTIL_LANGUAGES LANG " +
                    "ON MUP.S_LANGUAGE_ID=LANG.S_ID " +
                    "WHERE SECTORS.S_IP=? AND MUP.S_INCLUDED>0 " +
                    "ORDER BY MU.S_ID, MU.S_NAME,MUP.S_NAME";
            e.addAll(
                    getJdbcTemplate().query(
                            q, new RowMapper<FullMenuDBExtractor>() {
                                @Override
                                public FullMenuDBExtractor mapRow(ResultSet r, int i) throws SQLException {
                                    return new FullMenuDBExtractor(
                                            r.getInt(1),
                                            r.getString(2),
                                            r.getString(3),
                                            r.getLong(4),
                                            r.getString(5),
                                            r.getString(6),
                                            r.getDouble(7),
                                            r.getString(8),
//                                            r.getBlob(9),
                                            null,
                                            r.getDouble(10),
                                            r.getString(11),
                                            r.getString(12),
                                            r.getInt(13),
                                            r.getInt(14)
                                    );
                                }
                            }, remoteAddr
                    )
            );
            /*
            MenuCategory c_0 = new MenuCategory(e.get(0).getCategoryId(),e.get(0).getCategoryName(),e.get(0).getCategoryCode());
            MenuPosition p_0 = new MenuPosition(e.get(0).getPositionId(),e.get(0).getPositionLanguage(),e.get(0).getPositionName(),e.get(0).getPositionPrice(),e.get(0).getPositionDescription(),e.get(0).getPositionPicture(),e.get(0).getPositionQuantity(),e.get(0).getPositionUnits(),e.get(0).getPositionRecipeDescription(),e.get(0).getPositionStatus(),e.get(0).getPositionIncluded());
            for(int i=1; i<e.size(); i++) {
                MenuCategory c = new MenuCategory(
                        e.get(i).getCategoryId(),
                        e.get(i).getCategoryName(),
                        e.get(i).getCategoryCode()
                );
                MenuPosition p = new MenuPosition(
                        e.get(i).getPositionId(),
                        e.get(i).getPositionLanguage(),
                        e.get(i).getPositionName(),
                        e.get(i).getPositionPrice(),
                        e.get(i).getPositionDescription(),
                        e.get(i).getPositionPicture(),
                        e.get(i).getPositionQuantity(),
                        e.get(i).getPositionUnits(),
                        e.get(i).getPositionRecipeDescription(),
                        e.get(i).getPositionStatus(),
                        e.get(i).getPositionIncluded()
                );
            }
            return map;
            */
            return e;
        } catch(Exception e) {
            System.out.println("Ошибка получения меню");
            e.printStackTrace();
            return null;
        }
    }

    public int createAnonymousOrderOnTable(int tableId, String serializedOrder, String ipAddress) {
        try {
            CafeEventsDaoImpl eventsDao = new CafeEventsDaoImpl(this.getDataSource());
            ArrayList<PositionWithQuantity> pwqList = new ArrayList<PositionWithQuantity>();
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray)((JSONObject)parser.parse(serializedOrder)).get("orderPositions");
            for(int i=0; i< array.size();i++) {
                JSONObject j = (JSONObject)array.get(i);
                int k = Integer.parseInt(j.get("positionId").toString());
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
            String userid = "0";
            int orderId;
            try {
                orderId = getJdbcTemplate().queryForInt("select max(s_id) from " + defaultSchema + ".s_cafe_orders where s_client_id=? and s_table_num=? and s_date_close is null", userid, tableId);
                if(orderId<1) {
                    getJdbcTemplate().update("insert into "+defaultSchema+".s_cafe_orders (s_client_id, s_table_num, s_ip) values (?,?,?)", userid, tableId, ipAddress);
                }
            } catch (Exception e) {
                getJdbcTemplate().update("insert into " + defaultSchema + ".s_cafe_orders (s_client_id, s_table_num, s_ip) values (?,?,?)", userid, tableId, ipAddress);
            }
            orderId = getJdbcTemplate().queryForInt("select max(s_id) from "+defaultSchema+".s_cafe_orders where s_client_id=? and s_date_close is null", userid);
            for(PositionWithQuantity pwq: pwqList) {
                getJdbcTemplate().update("insert into "+defaultSchema+".s_cafe_order_positions (s_order_id, s_position_id, s_status, s_quant, s_date) values (?,?,?,?, ?)", orderId, pwq.getPositionId(), 0, pwq.getPositionQuantity(), new Date());
            }
            int spotId = eventsDao.getSpotIdBySpotIpAddress(ipAddress);
            eventsDao.putEvent(new InternalEvent(
                    0,
                    null,
                    11,
                    1,
                    tableId+"",
                    eventBody,
                    spotId,
                    0,
                    0,
                    orderId
            ), spotId);
            return orderId;
        } catch (Exception e) {
            System.out.println("Ошибка создания анонимного заказа.");
            e.printStackTrace();
            return 0;
        }
    }

    public int getMenuPositionPicture(int positionId, HttpServletResponse response) {
        LobHandler lobHandler = new DefaultLobHandler();
        OutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String query = "select  " +
                    "  (case when S_PICTURE is not null " +
                    "    then S_PICTURE " +
                    "    else (select S_PICTURE from S_CAFE_MENU_UNITS_POSITIONS WHERE S_ID=-1) end) as PICT " +
                    "  from "+defaultSchema+".S_CAFE_MENU_UNITS_POSITIONS where s_id="+positionId;
            final OutputStream finalOut = out;
            getJdbcTemplate().query(query, new AbstractLobStreamingResultSetExtractor() {
                protected void handleNoRowFound() throws LobRetrievalFailureException {
                    throw new IncorrectResultSizeDataAccessException(
                            "Image for position with id='" + positionId + "' was not found in database", 1, 0);
                }

                public void streamData(ResultSet rs) throws SQLException, IOException {
                    InputStream is = lobHandler.getBlobAsBinaryStream(rs, 1);
                    if (is != null) {
                        FileCopyUtils.copy(is, finalOut);
                    }
                }
            });
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
        /*response.setHeader("Content-Disposition", "inline;filename=\"" +positionId+".jpeg"+ "\"");
        try {
            response.setContentType("image/jpeg");
            IOUtils.copy(b.getS(), out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }*/
        return 1;
    }

    /*public int getMenuPositionPicture(int positionId, HttpServletResponse response) {
        BStream b = null;
        try {
            String query = "select s_picture from "+defaultSchema+".s_cafe_menu_units_positions where s_id="+positionId;
            b = getJdbcTemplate().queryForObject(query, new RowMapper<BStream>() {
                @Override
                public BStream mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new BStream(resultSet.getBinaryStream(1));
                }
            }, BStream.class);
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
        response.setHeader("Content-Disposition", "inline;filename=\"" +positionId+".jpeg"+ "\"");
        try {
            OutputStream out = response.getOutputStream();
            response.setContentType("image/jpeg");
            IOUtils.copy(b.getS(), out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }*/
}

class BStream {private InputStream s;public InputStream getS() {return s;}public void setS(InputStream s) {this.s = s;}BStream() {}BStream(InputStream s) {this.s = s;}}
