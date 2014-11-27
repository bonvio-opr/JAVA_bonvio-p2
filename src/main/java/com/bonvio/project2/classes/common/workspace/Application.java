package com.bonvio.project2.classes.common.workspace;

import java.util.List;

/**
 * Created by Arti Urskov on 17.04.14.
 */
public class Application {

    private int unitId;
    private int unitPositionX;
    private int unitPositionY;
    private String unitName;
    private String unitCode;
    private String unitImgPath;
    private int unitType;
    private List <Window> windows = null;

    @Override
    public String toString() {
        return "Application{" +
                "unitId=" + unitId +
                ", unitPositionX=" + unitPositionX +
                ", unitPositionY=" + unitPositionY +
                ", unitName='" + unitName + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", unitImgPath='" + unitImgPath + '\'' +
                ", windows=" + windows +
                '}';
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
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

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public Application() {

    }

    public Application(String unitName, String unitCode, String unitImgPath) {

        this.unitName = unitName;
        this.unitCode = unitCode;
        this.unitImgPath = unitImgPath;
    }

    public Application(int unitId, String unitName, String unitCode, String unitImgPath, int unitPositionX, int unitPositionY, int unitType) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.unitCode = unitCode;
        this.unitImgPath = unitImgPath;
        this.unitPositionX = unitPositionX;
        this.unitPositionY = unitPositionY;
        this.unitType = unitType;
    }
}
