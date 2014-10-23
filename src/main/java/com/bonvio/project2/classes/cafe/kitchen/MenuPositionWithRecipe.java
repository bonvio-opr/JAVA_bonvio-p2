package com.bonvio.project2.classes.cafe.kitchen;

import com.bonvio.project2.classes.cafe.clients.MenuPosition;

import java.sql.Blob;

/**
 * Created by Arti on 11.08.2014.
 */
public class MenuPositionWithRecipe extends MenuPosition {
    private String recipeDescription;

    @Override
    public String toString() {
        return "MenuPositionWithRecipe{" +
                "recipeDescription='" + recipeDescription + '\'' +
                '}';
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public MenuPositionWithRecipe() {}

    public MenuPositionWithRecipe(
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
            String recipeDescription
    ) {
        super(
                positionId,
                positionLanguage,
                positionName,
                positionPrice,
                positionDescription,
                null,
                positionQuantity,
                positionUnits,
                positionRecipeDescription,
                positionStatus,
                positionIncluded,
                positionCategoryType
        );
        this.recipeDescription = recipeDescription;
    }
}
