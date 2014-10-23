package com.bonvio.project2.classes.cafe.waiters;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Arti on 10.07.2014.
 */
public class Order {
    private int orderId;
    private String clientId;
    private Date date_open;
    private Date date_closed;
    private int tableNum;
    private String ip;
    private ArrayList<NamedPositionWithQuantity> pList;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", clientId='" + clientId + '\'' +
                ", date_open=" + date_open +
                ", date_closed=" + date_closed +
                ", tableNum=" + tableNum +
                ", ip='" + ip + '\'' +
                ", pList=" + pList +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Date getDate_open() {
        return date_open;
    }

    public void setDate_open(Date date_open) {
        this.date_open = date_open;
    }

    public Date getDate_closed() {
        return date_closed;
    }

    public void setDate_closed(Date date_closed) {
        this.date_closed = date_closed;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public ArrayList<NamedPositionWithQuantity> getpList() {
        return pList;
    }

    public void setpList(ArrayList<NamedPositionWithQuantity> pList) {
        this.pList = pList;
    }

    public Order() {

    }

    public Order(int orderId, String clientId, Date date_open, Date date_closed, int tableNum, String ip, ArrayList<NamedPositionWithQuantity> pList) {

        this.orderId = orderId;
        this.clientId = clientId;
        this.date_open = date_open;
        this.date_closed = date_closed;
        this.tableNum = tableNum;
        this.ip = ip;
        this.pList = pList;
    }
}
