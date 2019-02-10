package com.indev.blackfriday.factory;

import com.indev.blackfriday.StockEntry;

public interface StockEntryFactory {
    public StockEntry createEntry(int quantity, String productName, int price);
}
