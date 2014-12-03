package com.bonvio.project2.classes.cafe.waiters.internal;

import com.bonvio.project2.classes.cafe.waiters.internal.serializers.OrderForWaiterSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Arti on 29.07.2014.
 */
@JsonSerialize(using = OrderForWaiterSerializer.class)
public class OrderForWaiter {
    private Integer orderId;
    private Timestamp orderDateOpened;
    private Timestamp orderDateClosed;
    private Integer orderTableNumber;
    private Integer orderPosId;
    private Integer orderPosInOrderPosId;
    private String orderPosName;
    private Double orderPosQuant;
    private int orderPosStatus;

    @Override
    public String toString() {
        return "OrderForWaiter{" +
                "orderId=" + orderId +
                ", orderDateOpened=" + orderDateOpened +
                ", orderDateClosed=" + orderDateClosed +
                ", orderTableNumber=" + orderTableNumber +
                ", orderPosId=" + orderPosId +
                ", orderPosInOrderPosId=" + orderPosInOrderPosId +
                ", orderPosName='" + orderPosName + '\'' +
                ", orderPosQuant=" + orderPosQuant +
                ", orderPosStatus=" + orderPosStatus +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderDateOpened() {
        return orderDateOpened;
    }

    public void setOrderDateOpened(Timestamp orderDateOpened) {
        this.orderDateOpened = orderDateOpened;
    }

    public Timestamp getOrderDateClosed() {
        return orderDateClosed;
    }

    public void setOrderDateClosed(Timestamp orderDateClosed) {
        this.orderDateClosed = orderDateClosed;
    }

    public Integer getOrderTableNumber() {
        return orderTableNumber;
    }

    public void setOrderTableNumber(Integer orderTableNumber) {
        this.orderTableNumber = orderTableNumber;
    }

    public Integer getOrderPosId() {
        return orderPosId;
    }

    public void setOrderPosId(Integer orderPosId) {
        this.orderPosId = orderPosId;
    }

    public Integer getOrderPosInOrderPosId() {
        return orderPosInOrderPosId;
    }

    public void setOrderPosInOrderPosId(Integer orderPosInOrderPosId) {
        this.orderPosInOrderPosId = orderPosInOrderPosId;
    }

    public String getOrderPosName() {
        return orderPosName;
    }

    public void setOrderPosName(String orderPosName) {
        this.orderPosName = orderPosName;
    }

    public Double getOrderPosQuant() {
        return orderPosQuant;
    }

    public void setOrderPosQuant(Double orderPosQuant) {
        this.orderPosQuant = orderPosQuant;
    }

    public int getOrderPosStatus() {
        return orderPosStatus;
    }

    public void setOrderPosStatus(int orderPosStatus) {
        this.orderPosStatus = orderPosStatus;
    }

    public OrderForWaiter(Integer orderId, Timestamp orderDateOpened, Timestamp orderDateClosed, Integer orderTableNumber, Integer orderPosId, Integer orderPosInOrderPosId, String orderPosName, Double orderPosQuant, int orderPosStatus) {

        this.orderId = orderId;
        this.orderDateOpened = orderDateOpened;
        this.orderDateClosed = orderDateClosed;
        this.orderTableNumber = orderTableNumber;
        this.orderPosId = orderPosId;
        this.orderPosInOrderPosId = orderPosInOrderPosId;
        this.orderPosName = orderPosName;
        this.orderPosQuant = orderPosQuant;
        this.orderPosStatus = orderPosStatus;
    }
}
