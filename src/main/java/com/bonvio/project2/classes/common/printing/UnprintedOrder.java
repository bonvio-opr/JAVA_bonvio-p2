package com.bonvio.project2.classes.common.printing;

import java.util.LinkedList;

/**
 * Created by Arti on 26.09.2014.
 */
public class UnprintedOrder {
    private Integer orderId;
    private LinkedList<MenuPositionForPrinting> positions;

    @Override
    public String toString() {
        return "UnprintedOrder{" +
                "orderId=" + orderId +
                ", positions=" + positions +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LinkedList<MenuPositionForPrinting> getPositions() {
        return positions;
    }

    public void setPositions(LinkedList<MenuPositionForPrinting> positions) {
        this.positions = positions;
    }

    public UnprintedOrder() {

    }

    public UnprintedOrder(Integer orderId, LinkedList<MenuPositionForPrinting> positions) {

        this.orderId = orderId;
        this.positions = positions;
    }
}
