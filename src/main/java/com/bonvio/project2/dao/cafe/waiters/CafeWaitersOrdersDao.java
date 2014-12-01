package com.bonvio.project2.dao.cafe.waiters;

import com.bonvio.project2.classes.cafe.waiters.internal.OrderForWaiter;

import java.util.List;

/**
 * Created by Arti on 28.07.14.
 */
public interface CafeWaitersOrdersDao {
    public List<OrderForWaiter> getOrders();
    public java.util.LinkedList<OrderForWaiter> getOrderByOrderId(int orderId);
    public int closeOrderByOrderId(int orderId);
    public int changePositionStatus(int orderId, int s_id, int positionId, int newStatus);
    public int resizeOrderPosition(int orderId, int positionInMenuId, int positionInOrderId, int newQuant);
    public int addPositionToOrder(int orderId, int positionId, int addedQuant);
    public int removePositionFromOrder(int orderId, int s_id, int positionId);
}
