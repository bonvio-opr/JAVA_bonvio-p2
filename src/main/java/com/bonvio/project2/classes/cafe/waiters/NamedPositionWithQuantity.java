package com.bonvio.project2.classes.cafe.waiters;

import javax.jnlp.IntegrationService;

/**
 * Created by Arti on 02.07.2014.
 */
public class NamedPositionWithQuantity {
    private Integer posId;
    private String posName;
    private Double posQuant;

    @Override
    public String toString() {
        return "NamedPositionWithQuantity{" +
                "posId=" + posId +
                ", posName='" + posName + '\'' +
                ", posQuant=" + posQuant +
                '}';
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public Double getPosQuant() {
        return posQuant;
    }

    public void setPosQuant(Double posQuant) {
        this.posQuant = posQuant;
    }

    public NamedPositionWithQuantity() {

    }

    public NamedPositionWithQuantity(Integer posId, String posName, Double posQuant) {

        this.posId = posId;
        this.posName = posName;
        this.posQuant = posQuant;
    }
}
