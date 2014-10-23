package com.bonvio.project2.classes.common.printing;

/**
 * Created by Arti on 26.09.2014.
 */
public class MenuPositionForPrinting {
    private String name;
    private double quantity;
    private double price;

    @Override
    public String toString() {
        return "MenuPositionForPrinting{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MenuPositionForPrinting(String name, double quantity, double price) {

        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
