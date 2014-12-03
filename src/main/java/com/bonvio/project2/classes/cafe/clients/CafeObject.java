package com.bonvio.project2.classes.cafe.clients;

import java.util.ArrayList;

/**
 * Created by Arti on 25.06.2014.
 */

//@JsonSerialize(using = CafeObjectSerializer.class)
public class CafeObject {
    private String cafeName;
    private String spotName;
    private ArrayList<CafeSector> cafeSectors;

    @Override
    public String toString() {
        return "CafeObject{" +
                "cafeName='" + cafeName + '\'' +
                ", spotName='" + spotName + '\'' +
                ", cafeSectors=" + cafeSectors +
                '}';
    }

    public CafeObject() {
    }

    public String getCafeName() {

        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public ArrayList<CafeSector> getCafeSectors() {
        return cafeSectors;
    }

    public void setCafeSectors(ArrayList<CafeSector> cafeSectors) {
        this.cafeSectors = cafeSectors;
    }

    public CafeObject(String cafeName, String spotName, ArrayList<CafeSector> cafeSectors) {

        this.cafeName = cafeName;
        this.spotName = spotName;
        this.cafeSectors = cafeSectors;
    }
}
