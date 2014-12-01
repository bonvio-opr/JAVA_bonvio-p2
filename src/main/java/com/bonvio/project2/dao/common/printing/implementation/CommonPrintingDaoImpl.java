package com.bonvio.project2.dao.common.printing.implementation;

import com.bonvio.project2.classes.cafe.clients.PositionWithQuantity;
import com.bonvio.project2.classes.cafe.waiters.NamedPositionWithQuantity;
import com.bonvio.project2.classes.cafe.waiters.Order;
import com.bonvio.project2.classes.cafe.waiters.internal.OrderForWaiter;
import com.bonvio.project2.classes.common.printing.MenuPositionForPrinting;
import com.bonvio.project2.classes.common.printing.UnprintedOrder;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.common.printing.CommonPrintingDao;
import com.sun.rowset.internal.Row;
import gui.ava.html.image.generator.HtmlImageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.Sides;
import javax.sql.DataSource;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

/**
 * Created by Arti on 26.09.2014.
 */
public class CommonPrintingDaoImpl extends BaseDao implements CommonPrintingDao {

    @Autowired
    public CommonPrintingDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public LinkedList<UnprintedOrder> checkUnprinted(String remoteAddr) {
        try {
            LinkedList<UnprintedOrder> unprintedOrders = new LinkedList<>();
            List<Integer> iList = new LinkedList<>();
            iList.addAll(getJdbcTemplate().query("select s_order_id from " + defaultSchema + ".s_cafe_printcheck where s_ip=? order by s_order_id asc", new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                    return resultSet.getInt(1);
                }
            }, remoteAddr));
            if(iList.size()>0) {
                for (Integer i : iList) {
                    LinkedList<MenuPositionForPrinting> pwq = new LinkedList<>();
                    pwq.addAll(getJdbcTemplate().query("select " +
                            "POS.S_NAME, OP.S_QUANT, POS.S_PRICE " +
                            "from " + defaultSchema + ".S_CAFE_MENU_UNITS_POSITIONS POS " +
                            "left join S_CAFE_ORDER_POSITIONS OP " +
                            "on OP.S_POSITION_ID=POS.S_ID " +
                            "where OP.S_ORDER_ID=?", new RowMapper<MenuPositionForPrinting>() {
                        @Override
                        public MenuPositionForPrinting mapRow(ResultSet r, int i) throws SQLException {
                            return new MenuPositionForPrinting(
                                    r.getString(1),
                                    r.getDouble(2),
                                    r.getDouble(3)
                            );
                        }
                    }, i));
                    unprintedOrders.add(new UnprintedOrder(i, pwq));
                }
                String toDel = "(";
                for (int i = 0; i < iList.size() - 1; i++) {
//                toDel += "'"+iList.get(i)+"',";
                    toDel += iList.get(i) + ",";
                }
//            toDel+="'"+iList.get(iList.size()-1)+"')";
                toDel += iList.get(iList.size() - 1) + ")";
                String query = "delete from " + defaultSchema + ".S_CAFE_PRINTCHECK where s_ip='" + remoteAddr + "' and s_order_id in " + toDel;
                getJdbcTemplate().update(query);
                return unprintedOrders;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addToQueue(int orderId, String remoteAddr) {
        try {
            getJdbcTemplate().update("insert into "+defaultSchema+".s_cafe_printcheck (s_ip, s_order_id, s_fisc) values (?,"+orderId+",0)", remoteAddr);
            return 1;
        } catch (Exception e) {
            System.out.println("Невозможно добавить чек в очередь на печать. См.лог ошибок.");
            e.printStackTrace();
            return 0;
        }
    }
}
