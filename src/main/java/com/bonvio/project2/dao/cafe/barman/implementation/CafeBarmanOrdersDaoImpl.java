package com.bonvio.project2.dao.cafe.barman.implementation;

import com.bonvio.project2.classes.cafe.waiters.internal.InternalEvent;
import com.bonvio.project2.classes.cafe.waiters.internal.OrderForWaiter;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.cafe.barman.CafeBarmanOrdersDao;
import com.bonvio.project2.dao.cafe.events.implementation.CafeEventsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arti on 30.07.2014.
 */
public class CafeBarmanOrdersDaoImpl extends BaseDao implements CafeBarmanOrdersDao {

    @Autowired
    public CafeBarmanOrdersDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

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
                    "values (?,?,?,?)";
            getJdbcTemplate().update(q, orderId, positionId, addedQuant, new Date());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /*
    
    public int removePositionFromOrder(int orderId, int positionInMenuId, int positionInOrderId) {
        try {
            String q = "delete from "+defaultSchema+".s_cafe_order_positions where s_id="+orderId;
            getJdbcTemplate().update(q);


            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    */
    
    public int resizeOrderPosition(int orderId, int positionInMenuId, int positionInOrderId, int newQuant) {
        try {
            String q = "update "+defaultSchema+".s_cafe_order_positions set s_quant="+newQuant+" where s_id="+positionInOrderId+" and s_order_id="+orderId+" and s_position_id="+positionInMenuId;
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int statusSetAccepted(int orderId, int positionId, String ipAddress) {
        try {
            getJdbcTemplate().update("update "+defaultSchema+".s_cafe_order_positions set s_status=3 where s_order_id="+orderId+" and  and s_id="+positionId);
            int spotId = getSpotIdBySpotIpAddress(ipAddress);
            eventsDao.putEvent(
                    new InternalEvent(
                            0,
                            null,
                            21,
                            1,
                            getTableNumByOrderId(orderId)  + " стол: позиция принята на приготовление",
                            "",
                            spotId,
                            0,
                            0,
                            orderId
                    ),
                    spotId
            );
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int statusSetRejected(int orderId, int positionId, String ipAddress) {
        try {
            getJdbcTemplate().update("update "+defaultSchema+".s_cafe_order_positions set s_status=4 where s_order_id="+orderId+" and  and s_id="+positionId);
            int spotId = getSpotIdBySpotIpAddress(ipAddress);
            eventsDao.putEvent(
                    new InternalEvent(
                            0,
                            null,
                            24,
                            1,
                            getTableNumByOrderId(orderId)  + " стол: приготовление невозможно",
                            "",
                            spotId,
                            0,
                            0,
                            orderId
                    ),
                    spotId
            );
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int statusSetReady(int orderId, int positionId, String ipAddress) {
        try {
            getJdbcTemplate().update("update "+defaultSchema+".s_cafe_order_positions set s_status=5 where s_order_id="+orderId+" and  and s_id="+positionId);
            int spotId = getSpotIdBySpotIpAddress(ipAddress);
            eventsDao.putEvent(
                    new InternalEvent(
                            0,
                            null,
                            25,
                            1,
                            getTableNumByOrderId(orderId)  + " стол: позиция готова к отдаче клиенту",
                            "",
                            spotId,
                            0,
                            0,
                            orderId
                    ),
                    spotId
            );
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
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

    public int storeFastSell(int positionId, int positionQuantity, String ipAddress) {
        try {
            String q = "insert into "+defaultSchema+".s_cafe_fast_sells (s_pos_id, s_quantity, s_date, s_ip) values (?,?,CURRENT_TIMESTAMP, ?)";
            getJdbcTemplate().update(q, positionId, positionQuantity, ipAddress);
            return 1;
        }catch (Exception e) {
            System.out.println("Ошибка добавлеия позиции быстрой продажи");
            e.printStackTrace();
            return 0;
        }
    }
}
