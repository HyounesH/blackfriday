package com.indev.blackfriday;

import com.indev.blackfriday.factory.StockEntryFactory;
import com.indev.blackfriday.factory.StockProducEntryFactory;

import java.util.HashMap;
import java.util.Map;

public class Company {
    public static  final int SELL_FIXED_QUANTITY=5;
    public static  final double MARGIN_PRICE_EACH_SELL=1.2;
    private Map<String,StockEntry> stockEntries=new HashMap<String, StockEntry>();
    private StockEntryFactory stockEntryFactory=StockProducEntryFactory.getInstance();
    private  float totalsells=0;
    public float sells(String productName) {
         if(checkStock(productName)) {
             StockEntry stockEntry = stockEntries.get(productName);
             float sells = (float) (stockEntry.getPrice() * SELL_FIXED_QUANTITY * MARGIN_PRICE_EACH_SELL);
             this.totalsells += sells;
             stockEntry.setQuantity(stockEntry.getQuantity() - SELL_FIXED_QUANTITY);
             stockEntries.put(productName, stockEntry);
             return sells;
         }
         else{
             throw new RuntimeException("no stock available");
         }

    }

    private boolean checkStock(String productName) {
        StockEntry stockEntry=stockEntries.get(productName);
        return  stockEntry.getQuantity()>=SELL_FIXED_QUANTITY;
    }

    public void stock(int quantity, String productName, int price) {
     stockEntries.put(productName,stockEntryFactory.createEntry(quantity,productName,price));
    }

    public Company to(int i) {
        return this;
    }

    public float computeBenefit() {
        return 0;
    }

    public int totalAssets() {
        int totalAssets=0;
        for(StockEntry stockEntry:stockEntries.values()){
            totalAssets+=stockEntry.getPrice()*stockEntry.getQuantity();
        }
        totalAssets+=totalsells;
        return  totalAssets;
    }

    public Company blackFriday()
    {
        return this;
    }
}
