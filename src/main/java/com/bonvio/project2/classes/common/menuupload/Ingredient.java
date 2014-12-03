package com.bonvio.project2.classes.common.menuupload;

/**
 * Created by Arti on 12.08.2014.
 */
public class Ingredient {
    private int ingredientId;
    private String ingredientName;
    private int spotId;

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", ingredientName='" + ingredientName + '\'' +
                ", spotId=" + spotId +
                '}';
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public Ingredient() {
    }

    public Ingredient(int ingredientId, String ingredientName, int spotId) {

        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.spotId = spotId;
    }
}
