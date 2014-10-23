package com.bonvio.project2.classes.cafe.clients;

import java.util.ArrayList;

/**
 * Created by Arti on 25.06.2014.
 */
public class CafeMenu implements Cloneable {
    private String categoryName;
    private String categoryCode;
    private ArrayList<MenuPosition> positions;

    @Override
    public String toString() {
        return "CafeMenu{" +
                "positions=" + positions +
                ", categoryCode='" + categoryCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public ArrayList<MenuPosition> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<MenuPosition> positions) {
        this.positions = positions;
    }

    public CafeMenu() {

    }

    public CafeMenu(String categoryName, String categoryCode, ArrayList<MenuPosition> positions) {

        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.positions = positions;
    }
}