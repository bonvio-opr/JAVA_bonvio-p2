package com.bonvio.project2.classes.cafe.waiters.extractors;

import java.util.Date;

/**
 * Created by Arti on 02.07.2014.
 */
public class OrdersWithTableNamesDBExtractor {
    private Integer id;
    private Integer tableNum;
    private Integer orderId;
    private Integer positionId;
    private String positionName;
    private Double positinQuantity;
    private Date positionOrderedDate;
    private Integer positionStatus;

    @Override
    public String toString() {
        return "OrdersWithTableNamesDBExtractor{" +
                "id=" + id +
                ", tableNum=" + tableNum +
                ", orderId=" + orderId +
                ", positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", positinQuantity=" + positinQuantity +
                ", positionOrderedDate=" + positionOrderedDate +
                ", positionStatus=" + positionStatus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableNum() {
        return tableNum;
    }

    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Double getPositinQuantity() {
        return positinQuantity;
    }

    public void setPositinQuantity(Double positinQuantity) {
        this.positinQuantity = positinQuantity;
    }

    public Date getPositionOrderedDate() {
        return positionOrderedDate;
    }

    public void setPositionOrderedDate(Date positionOrderedDate) {
        this.positionOrderedDate = positionOrderedDate;
    }

    public Integer getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(Integer positionStatus) {
        this.positionStatus = positionStatus;
    }

    public OrdersWithTableNamesDBExtractor() {

    }

    public OrdersWithTableNamesDBExtractor(Integer id, Integer tableNum, Integer orderId, Integer positionId, String positionName, Double positinQuantity, Date positionOrderedDate, Integer positionStatus) {

        this.id = id;
        this.tableNum = tableNum;
        this.orderId = orderId;
        this.positionId = positionId;
        this.positionName = positionName;
        this.positinQuantity = positinQuantity;
        this.positionOrderedDate = positionOrderedDate;
        this.positionStatus = positionStatus;
    }
}
