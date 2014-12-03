package com.bonvio.project2.classes.common.menuupload;

/**
 * Created by Arti on 28.08.2014.
 */
public class IngredientInRecipe extends Ingredient {
    private double quantity;
    private String units;

    public IngredientInRecipe(String units, double quantity) {
        this.units = units;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "IngredientInRecipe{" +
                "quantity=" + quantity +
                ", units='" + units + '\'' +
                '}';
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public IngredientInRecipe(int ingredientId, String ingredientName, int spotId, String units, double quantity) {
        super(ingredientId, ingredientName, spotId);
        this.units = units;
        this.quantity = quantity;
    }
}
