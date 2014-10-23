package com.bonvio.project2.classes.common.workspace;

/**
 * Created by Arti Urskov on 17.04.14.
 */
public class Application {
    private String unitName;
    private String unitCode;
    private String unitImgPath;

    @Override
    public String toString() {
        return "Application{" +
                "unitName='" + unitName + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", unitImgPath='" + unitImgPath + '\'' +
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

    public Application() {

    }

    public Application(String unitName, String unitCode, String unitImgPath) {

        this.unitName = unitName;
        this.unitCode = unitCode;
        this.unitImgPath = unitImgPath;
    }
}
