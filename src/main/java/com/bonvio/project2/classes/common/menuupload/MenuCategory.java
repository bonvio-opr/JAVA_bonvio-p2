package com.bonvio.project2.classes.common.menuupload;

/**
 * Created by Arti on 01.09.2014.
 */
public class MenuCategory {
    private int categoryId;
    private String categoryName;
    private String categoryCode;
    private int categoryType;

    @Override
    public String toString() {
        return "MenuCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    public MenuCategory() {

    }

    public MenuCategory(int categoryId, String categoryName, String categoryCode, int categoryType) {

        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.categoryType = categoryType;
    }
}
