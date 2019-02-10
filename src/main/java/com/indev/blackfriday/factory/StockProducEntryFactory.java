package com.indev.blackfriday.factory;

import com.indev.blackfriday.StockEntry;

public class StockProducEntryFactory implements  StockEntryFactory {
    public static StockProducEntryFactory instance=null;
    private StockProducEntryFactory(){}
    public static  StockProducEntryFactory getInstance(){
        if(instance==null) instance=new StockProducEntryFactory();
        return instance;
    }
    public StockEntry createEntry(int quantity, String productName, int price) {
        return new StockEntry(productName,price,quantity);
    }
}
