package com.bonvio.project2.dao.cafe.kitchen.implementation;

import com.bonvio.project2.classes.cafe.kitchen.MenuPositionWithRecipe;
import com.bonvio.project2.classes.cafe.waiters.internal.OrderForWaiter;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.cafe.kitchen.CafeKitchenOrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arti on 30.07.2014.
 */
public class CafeKitchenOrdersDaoImpl extends BaseDao implements CafeKitchenOrdersDao {
    @Autowired
    public CafeKitchenOrdersDaoImpl(DataSource dataSource) {super(dataSource);}

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
//                "where ORD.S_ID=? " +
                            "order by ORD.S_ID, OP.S_DATE";
            oList.addAll(getJdbcTemplate().query(q, new RowMapper<OrderForWaiter>() {
                @Override
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
            return oList;
        } catch (Exception e) {
            return null;
        }
    }

    public OrderForWaiter getOrderByOrderId(int orderId) {
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
                            "where " +
                            "ORD.S_ID=? " +
                            "order by ORD.S_ID, OP.S_DATE";
            return getJdbcTemplate().queryForObject(q, new RowMapper<OrderForWaiter>() {
                @Override
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
            }, OrderForWaiter.class, orderId);
        } catch (Exception e) {
            return null;
        }
    }

    /*@Override
    public MenuPositionWithRecipe getMenuPositionById(int positionId) {
        try {
            MenuPositionWithRecipe m  =new MenuPositionWithRecipe();
            return (MenuPositionWithRecipe)getJdbcTemplate().query("select * from "+defaultSchema+".s_cafe_menu_unit_positions where s_id=?", new RowMapper<MenuPositionWithRecipe>() {
                @Override
                public MenuPositionWithRecipe mapRow(ResultSet r, int i) throws SQLException {
                    return new MenuPositionWithRecipe(
                            r.getLong(1),
                            r.getString(2),
                            r.getString(3),
                            r.getDouble(4),
                            r.getString(5),
                            r.getString(6),
                            r.getDouble(7),
                            r.getString(8),
                            r.getInt(9),
                            r.getString(10)
                    );
                }
            }, positionId, MenuPositionWithRecipe.class);
        } catch (Exception e) {
            System.out.println("Ошибка: не удалось получить информацию о позиции. Ошибка запроса к БД");
            e.printStackTrace();
            return null;
        }
    }*/

    public int statusSetAccepted(int orderId, int positionId) {
        try {
            String q = "update "+defaultSchema+".s_cafe_orders set s_status=3 where s_order_id="+orderId+" and  and s_id="+positionId;
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int statusSetRejected(int orderId, int positionId) {
        try {
            getJdbcTemplate().update("update "+defaultSchema+".s_cafe_orders set s_status=4 where s_order_id="+orderId+" and  and s_id="+positionId);
//            getJdbcTemplate().update("insert into "+defaultSchema+".a_cafe_events ()");
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int statusSetReady(int orderId, int positionId) {
        try {
            String q = "update "+defaultSchema+".s_cafe_orders set s_status=5 where s_order_id="+orderId+" and  and s_id="+positionId;
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /*public int changeOrderPositionIdStatus(int orderId, int positionId, int newStatus) {
        try {
            String q = "update "+defaultSchema+".s_cafe_orders set s_status=1 where s_order_id="+orderId+" and s_positionId="+positionId+" and s_id="+s_id;
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int rejectOrderPosition(String posId, String reason) {
        return 0;
    }*/
}