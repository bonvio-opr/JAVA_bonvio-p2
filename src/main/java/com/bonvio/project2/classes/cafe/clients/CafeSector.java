package com.bonvio.project2.classes.cafe.clients;

import java.util.ArrayList;

/**
 * Created by Arti on 25.06.2014.
 */
public class CafeSector {
    private String sectorName;
    private String sectorIp;
    private Integer tableQuantity;
    private ArrayList<CafeMenu> listOfMenues;

    @Override
    public String toString() {
        return "CafeSector{" +
                "sectorName='" + sectorName + '\'' +
                ", sectorIp='" + sectorIp + '\'' +
                ", tableQuantity=" + tableQuantity +
                ", listOfMenues=" + listOfMenues +
                '}';
    }

    public CafeSector() {
    }

    public String getSectorName() {

        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getSectorIp() {
        return sectorIp;
    }

    public void setSectorIp(String sectorIp) {
        this.sectorIp = sectorIp;
    }

    public Integer getTableQuantity() {
        return tableQuantity;
    }

    public void setTableQuantity(Integer tableQuantity) {
        this.tableQuantity = tableQuantity;
    }

    public ArrayList<CafeMenu> getListOfMenues() {
        return listOfMenues;
    }

    public void setListOfMenues(ArrayList<CafeMenu> listOfMenues) {
        this.listOfMenues = listOfMenues;
    }

    public CafeSector(String sectorName, String sectorIp, Integer tableQuantity, ArrayList<CafeMenu> listOfMenues) {

        this.sectorName = sectorName;
        this.sectorIp = sectorIp;
        this.tableQuantity = tableQuantity;
        this.listOfMenues = listOfMenues;
    }
}
