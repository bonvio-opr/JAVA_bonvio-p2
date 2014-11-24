package com.bonvio.project2.classes.common.workspace;

import java.util.List;

/**
 * Created by Arti Urskov on 17.04.14.
 */
public class Application {

    private long uniteID;
    private int unitPositionX;
    private int unitPositionY;
    private String unitName;
    private String unitCode;
    private String unitImgPath;
    private List <Application> windows = null;

    @Override
    public String toString() {
        return "Application{" +
                "uniteID=" + uniteID +
                ", unitPositionX=" + unitPositionX +
                ", unitPositionY=" + unitPositionY +
                ", unitName='" + unitName + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", unitImgPath='" + unitImgPath + '\'' +
                ", windows=" + windows +
                '}';
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitImgPath() {
        return unitImgPath;
    }

    public void setUnitImgPath(String unitImgPath) {
        this.unitImgPath = unitImgPath;
    }

    public long getUniteID() {
        return uniteID;
    }

    public void setUniteID(long uniteID) {
        this.uniteID = uniteID;
    }

    public int getUnitPositionX() {
        return unitPositionX;
    }

    public void setUnitPositionX(int unitPositionX) {
        this.unitPositionX = unitPositionX;
    }

    public int getUnitPositionY() {
        return unitPositionY;
    }

    public void setUnitPositionY(int unitPositionY) {
        this.unitPositionY = unitPositionY;
    }

    public Application() {

    }

    public Application(String unitName, String unitCode, String unitImgPath) {

        this.unitName = unitName;
        this.unitCode = unitCode;
        this.unitImgPath = unitImgPath;
    }

    public Application(long uniteID, String unitName, String unitCode, String unitImgPath, int unitPositionX, int unitPositionY) {
        this.uniteID = uniteID;
        this.unitName = unitName;
        this.unitCode = unitCode;
        this.unitImgPath = unitImgPath;
        this.unitPositionX = unitPositionX;
        this.unitPositionY = unitPositionY;
    }
}
