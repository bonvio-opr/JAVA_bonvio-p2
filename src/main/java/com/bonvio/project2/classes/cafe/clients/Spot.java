package com.bonvio.project2.classes.cafe.clients;

/**
 * Created by Arti on 19.06.2014.
 */
public class Spot {
    private String spotName;
    private String address;
    private Double lat;
    private Double lon;

    @Override
    public String toString() {
        return "Spot{" +
                "lon=" + lon +
                ", spotName='" + spotName + '\'' +
                ", address='" + address + '\'' +
                ", lat=" + lat +
                '}';
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Spot() {

    }

    public Spot(String spotName, String address, Double lat, Double lon) {

        this.spotName = spotName;
        this.address = address;
        this.lat = lat;
        this.lon = lon;
    }
}
