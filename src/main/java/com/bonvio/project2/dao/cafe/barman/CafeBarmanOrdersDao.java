package com.bonvio.project2.dao.cafe.barman;

import com.bonvio.project2.classes.cafe.waiters.internal.OrderForWaiter;

import java.util.List;

/**
 * Created by Arti on 30.07.2014.
 */
public interface CafeBarmanOrdersDao {
    public List<OrderForWaiter> getOrders();
    public java.util.LinkedList<OrderForWaiter> getOrderByOrderId(int orderId);
    public int closeOrderByOrderId(int orderId);
    public int changePositionStatus(int orderId, int s_id, int positionId, int newStatus);
    public int resizeOrderPosition(int orderId, int positionInMenuId, int positionInOrderId, int newQuant);
    public int addPositionToOrder(int orderId, int positionId, int addedQuant);
    public int statusSetReady(int orderId, int positionId, String ipAddress);
    public int statusSetRejected(int orderId, int positionId, String ipAddress);
    public int statusSetAccepted(int orderId, int positionId, String ipAddress);
}
