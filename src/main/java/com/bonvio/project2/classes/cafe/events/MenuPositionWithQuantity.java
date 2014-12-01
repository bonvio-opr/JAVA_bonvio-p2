package com.bonvio.project2.classes.cafe.events;

import com.bonvio.project2.classes.cafe.clients.MenuPosition;
import com.bonvio.project2.classes.cafe.clients.serializers.MenuPositionSerializer;
import com.bonvio.project2.classes.cafe.events.serializers.MenuPositionWithQuantitySerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.sql.Blob;

/**
 * Created by Arti on 19.08.2014.
 */
@JsonSerialize(using = MenuPositionWithQuantitySerializer.class)
public class MenuPositionWithQuantity extends MenuPosition {
    private double positionQuantityInOrder;

    public double getPositionQuantityInOrder() {
        return positionQuantityInOrder;
    }

    public void setPositionQuantityInOrder(double positionQuantityInOrder) {
        this.positionQuantityInOrder = positionQuantityInOrder;
    }

    public MenuPositionWithQuantity(double positionQuantityInOrder) {

        this.positionQuantityInOrder = positionQuantityInOrder;
    }

    public MenuPositionWithQuantity(
            Long positionId,
            String positionLanguage,
            String positionName,
            Double positionPrice,
            String positionDescription,
            /*Blob positionPicture,*/
            Double positionQuantity,
            String positionUnits,
            String positionRecipeDescription,
            int positionStatus,
            int positionIncluded,
            int positionCategoryType,
            double positionQuantityInOrder
    ) {
        super(positionId, positionLanguage, positionName, positionPrice, positionDescription, null, positionQuantity, positionUnits, positionRecipeDescription, positionStatus, positionIncluded, positionCategoryType);
        this.positionQuantityInOrder = positionQuantityInOrder;
    }

    public MenuPositionWithQuantity() {

    }
}
