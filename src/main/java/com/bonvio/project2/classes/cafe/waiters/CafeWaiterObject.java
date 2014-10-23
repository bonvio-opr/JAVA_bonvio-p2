package com.bonvio.project2.classes.cafe.waiters;

import com.bonvio.project2.classes.cafe.clients.CafeSector;
import com.bonvio.project2.classes.cafe.clients.PositionWithQuantity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Arti on 02.07.2014.
 */
public class CafeWaiterObject  {
    private Integer tQuantity;
    private String spotName;
    private HashMap<Integer, ArrayList<PositionWithQuantity>> tableWithOrderPositions;


    @Override
    public String toString() {
        return "CafeWaiterObject{" +
                "tQuantity=" + tQuantity +
                ", spotName='" + spotName + '\'' +
                ", tableWithOrderPositions=" + tableWithOrderPositions +
                '}';
    }

    public Integer gettQuantity() {
        return tQuantity;
    }

    public void settQuantity(Integer tQuantity) {
        this.tQuantity = tQuantity;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public HashMap<Integer, ArrayList<PositionWithQuantity>> getTableWithOrderPositions() {
        return tableWithOrderPositions;
    }

    public void setTableWithOrderPositions(HashMap<Integer, ArrayList<PositionWithQuantity>> tableWithOrderPositions) {
        this.tableWithOrderPositions = tableWithOrderPositions;
    }

    public CafeWaiterObject() {

    }

    public CafeWaiterObject(Integer tQuantity, String spotName, HashMap<Integer, ArrayList<PositionWithQuantity>> tableWithOrderPositions) {

        this.tQuantity = tQuantity;
        this.spotName = spotName;
        this.tableWithOrderPositions = tableWithOrderPositions;
    }
}
