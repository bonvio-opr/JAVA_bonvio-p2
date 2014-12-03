package com.bonvio.project2.classes.cafe.clients;

/**
 * Created by Arti on 30.06.2014.
 */
public class PositionWithQuantity {
    private int positionId;
    private String positionName;
    private Double positionQuantity;

    @Override
    public String toString() {
        return "PositionWithQuantity{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", positionQuantity=" + positionQuantity +
                '}';
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Double getPositionQuantity() {
        return positionQuantity;
    }

    public void setPositionQuantity(Double positionQuantity) {
        this.positionQuantity = positionQuantity;
    }

    public PositionWithQuantity() {

    }

    public PositionWithQuantity(int positionId, String positionName, Double positionQuantity) {

        this.positionId = positionId;
        this.positionName = positionName;
        this.positionQuantity = positionQuantity;
    }
}
