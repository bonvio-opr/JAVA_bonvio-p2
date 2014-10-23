package com.bonvio.project2.classes.cafe.clients;


import com.bonvio.project2.classes.cafe.clients.serializers.MenuPositionSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.sql.Blob;

/**
 * Created by Arti on 25.06.2014.
 */
@JsonSerialize(using = MenuPositionSerializer.class)
public class MenuPosition {
    private Long positionId;
    private String positionLanguage;
    private String positionName;
    private Double positionPrice;
    private String positionDescription;
    private Blob positionPicture;
    private Double positionQuantity;
    private String positionUnits;
    private String positionRecipeDescription;
    private int positionStatus;
    private int positionIncluded;
    private int positionCategoryType;

    @Override
    public String toString() {
        return "MenuPosition{" +
                "positionId=" + positionId +
                ", positionLanguage='" + positionLanguage + '\'' +
                ", positionName='" + positionName + '\'' +
                ", positionPrice=" + positionPrice +
                ", positionDescription='" + positionDescription + '\'' +
                ", positionPicture=" + positionPicture +
                ", positionQuantity=" + positionQuantity +
                ", positionUnits='" + positionUnits + '\'' +
                ", positionRecipeDescription='" + positionRecipeDescription + '\'' +
                ", positionStatus=" + positionStatus +
                ", positionIncluded=" + positionIncluded +
                ", positionCategoryType=" + positionCategoryType +
                '}';
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionLanguage() {
        return positionLanguage;
    }

    public void setPositionLanguage(String positionLanguage) {
        this.positionLanguage = positionLanguage;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Double getPositionPrice() {
        return positionPrice;
    }

    public void setPositionPrice(Double positionPrice) {
        this.positionPrice = positionPrice;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public Blob getPositionPicture() {
        return positionPicture;
    }

    public void setPositionPicture(Blob positionPicture) {
        this.positionPicture = positionPicture;
    }

    public Double getPositionQuantity() {
        return positionQuantity;
    }

    public void setPositionQuantity(Double positionQuantity) {
        this.positionQuantity = positionQuantity;
    }

    public String getPositionUnits() {
        return positionUnits;
    }

    public void setPositionUnits(String positionUnits) {
        this.positionUnits = positionUnits;
    }

    public String getPositionRecipeDescription() {
        return positionRecipeDescription;
    }

    public void setPositionRecipeDescription(String positionRecipeDescription) {
        this.positionRecipeDescription = positionRecipeDescription;
    }

    public int getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(int positionStatus) {
        this.positionStatus = positionStatus;
    }

    public int getPositionIncluded() {
        return positionIncluded;
    }

    public void setPositionIncluded(int positionIncluded) {
        this.positionIncluded = positionIncluded;
    }

    public int getPositionCategoryType() {
        return positionCategoryType;
    }

    public void setPositionCategoryType(int positionCategoryType) {
        this.positionCategoryType = positionCategoryType;
    }

    public MenuPosition() {

    }

    public MenuPosition(
            Long positionId,
            String positionLanguage,
            String positionName,
            Double positionPrice,
            String positionDescription,
            Blob positionPicture,
            Double positionQuantity,
            String positionUnits,
            String positionRecipeDescription,
            int positionStatus,
            int positionIncluded,
            int positionCategoryType
    ) {

        this.positionId = positionId;
        this.positionLanguage = positionLanguage;
        this.positionName = positionName;
        this.positionPrice = positionPrice;
        this.positionDescription = positionDescription;
        this.positionPicture = positionPicture;
        this.positionQuantity = positionQuantity;
        this.positionUnits = positionUnits;
        this.positionRecipeDescription = positionRecipeDescription;
        this.positionStatus = positionStatus;
        this.positionIncluded = positionIncluded;
        this.positionCategoryType = positionCategoryType;
    }
}
