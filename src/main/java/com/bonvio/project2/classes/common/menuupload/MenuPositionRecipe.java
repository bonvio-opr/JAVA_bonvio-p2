package com.bonvio.project2.classes.common.menuupload;

import com.bonvio.project2.classes.cafe.clients.MenuPosition;

import java.sql.Blob;
import java.util.LinkedList;

/**
 * Created by Arti on 12.08.2014.
 */
public class MenuPositionRecipe extends MenuPosition {
    private LinkedList<IngredientInRecipe> positionIngredients;
    private String positionRecipeInstruction;


    public MenuPositionRecipe() {
    }

    @Override
    public String toString() {
        return "MenuPositionRecipe{" +
                "positionIngredients=" + positionIngredients +
                ", positionRecipeInstruction='" + positionRecipeInstruction + '\'' +
                '}';
    }

    public LinkedList<IngredientInRecipe> getPositionIngredients() {
        return positionIngredients;
    }

    public void setPositionIngredients(LinkedList<IngredientInRecipe> positionIngredients) {
        this.positionIngredients = positionIngredients;
    }

    public String getPositionRecipeInstruction() {
        return positionRecipeInstruction;
    }

    public void setPositionRecipeInstruction(String positionRecipeInstruction) {
        this.positionRecipeInstruction = positionRecipeInstruction;
    }

    public MenuPositionRecipe(LinkedList<IngredientInRecipe> positionIngredients, String positionRecipeInstruction) {

        this.positionIngredients = positionIngredients;
        this.positionRecipeInstruction = positionRecipeInstruction;
    }

    public MenuPositionRecipe(
            Long positionId,
            String positionLanguage,
            String positionName,
            Double positionPrice,
            String positionDescription,
            Double positionQuantity,
            String positionUnits,
            String positionRecipeDescription,
            int positionStatus,
            int positionIncluded,
            int positionCategoryType,
            LinkedList<IngredientInRecipe> positionIngredients,
            String positionRecipeInstruction
    ) {
        super(positionId, positionLanguage, positionName, positionPrice, positionDescription, null, positionQuantity, positionUnits, positionRecipeDescription, positionStatus, positionIncluded, positionCategoryType);
        this.positionIngredients = positionIngredients;
        this.positionRecipeInstruction = positionRecipeInstruction;
    }
}
