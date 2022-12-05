package com.race.models;

import android.widget.Button;
import android.widget.CheckBox;

public class Item {
    int itemThumb;
    String itemName, itemCategory, itemDiscount, itemNumber;
    double itemPrice;

    public Item(int itemThumb, String itemNumber, String itemName, String itemCategory, String itemDiscount, double itemPrice) {
        this.itemThumb = itemThumb;
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemDiscount = itemDiscount;
        this.itemPrice = itemPrice;
    }

    public int getItemThumb() {
        return itemThumb;
    }

    public void setItemThumb(int itemThumb) {
        this.itemThumb = itemThumb;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(String itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
