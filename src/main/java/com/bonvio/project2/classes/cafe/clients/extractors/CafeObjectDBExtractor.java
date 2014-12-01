package com.bonvio.project2.classes.cafe.clients.extractors;

import java.sql.Blob;

/**
 * Created by Arti on 30.06.2014.
 */
public class CafeObjectDBExtractor {
    private String cafeName;
    private String spotName;
    private String sectorName;
    private String sectorIp;
    private String catName;
    private String catCode;
    private String posId;
    private String posLang;
    private String posName;
    private String posDescription;
    private Blob posPictureLink;
    private double posPrice;
    private double posQuantity;
    private String posUnits;
    private int posIncluded;
    private int posCatType;

    @Override
    public String toString() {
        return "CafeObjectDBExtractor{" +
                "cafeName='" + cafeName + '\'' +
                ", spotName='" + spotName + '\'' +
                ", sectorName='" + sectorName + '\'' +
                ", sectorIp='" + sectorIp + '\'' +
                ", catName='" + catName + '\'' +
                ", catCode='" + catCode + '\'' +
                ", posId='" + posId + '\'' +
                ", posLang='" + posLang + '\'' +
                ", posName='" + posName + '\'' +
                ", posDescription='" + posDescription + '\'' +
                ", posPictureLink=" + posPictureLink +
                ", posPrice=" + posPrice +
                ", posQuantity=" + posQuantity +
                ", posUnits='" + posUnits + '\'' +
                ", posIncluded=" + posIncluded +
                ", posCatType=" + posCatType +
                '}';
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getSectorIp() {
        return sectorIp;
    }

    public void setSectorIp(String sectorIp) {
        this.sectorIp = sectorIp;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatCode() {
        return catCode;
    }

    public void setCatCode(String catCode) {
        this.catCode = catCode;
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public String getPosLang() {
        return posLang;
    }

    public void setPosLang(String posLang) {
        this.posLang = posLang;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getPosDescription() {
        return posDescription;
    }

    public void setPosDescription(String posDescription) {
        this.posDescription = posDescription;
    }

    public Blob getPosPictureLink() {
        return posPictureLink;
    }

    public void setPosPictureLink(Blob posPictureLink) {
        this.posPictureLink = posPictureLink;
    }

    public double getPosPrice() {
        return posPrice;
    }

    public void setPosPrice(double posPrice) {
        this.posPrice = posPrice;
    }

    public double getPosQuantity() {
        return posQuantity;
    }

    public void setPosQuantity(double posQuantity) {
        this.posQuantity = posQuantity;
    }

    public String getPosUnits() {
        return posUnits;
    }

    public void setPosUnits(String posUnits) {
        this.posUnits = posUnits;
    }

    public int getPosIncluded() {
        return posIncluded;
    }

    public void setPosIncluded(int posIncluded) {
        this.posIncluded = posIncluded;
    }

    public int getPosCatType() {
        return posCatType;
    }

    public void setPosCatType(int posCatType) {
        this.posCatType = posCatType;
    }

    public CafeObjectDBExtractor(String cafeName, String spotName, String sectorName, String sectorIp, String catName, String catCode, String posId, String posLang, String posName, String posDescription, Blob posPictureLink, double posPrice, double posQuantity, String posUnits, int posIncluded, int posCatType) {

        this.cafeName = cafeName;
        this.spotName = spotName;
        this.sectorName = sectorName;
        this.sectorIp = sectorIp;
        this.catName = catName;
        this.catCode = catCode;
        this.posId = posId;
        this.posLang = posLang;
        this.posName = posName;
        this.posDescription = posDescription;
        this.posPictureLink = posPictureLink;
        this.posPrice = posPrice;
        this.posQuantity = posQuantity;
        this.posUnits = posUnits;
        this.posIncluded = posIncluded;
        this.posCatType = posCatType;
    }
}
