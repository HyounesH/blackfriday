package com.indev.blackfriday;


public class StockEntry {
    private String productName;
    private int price;
    private int quantity;


    public StockEntry(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }




    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
