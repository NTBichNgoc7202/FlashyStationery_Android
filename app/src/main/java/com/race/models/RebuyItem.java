package com.race.models;

public class RebuyItem {
    int reThumb ;
    String reName, reCategory, rePrice, reNumber;

    public RebuyItem(int reThumb,String reNumber, String reName, String reCategory, String rePrice) {
        this.reThumb = reThumb;
        this.reName = reName;
        this.reCategory = reCategory;
        this.rePrice = rePrice;
        this.reNumber = reNumber;
    }

    public int getReThumb() {
        return reThumb;
    }

    public void setReThumb(int reThumb) {
        this.reThumb = reThumb;
    }

    public String getReName() {
        return reName;
    }

    public void setReName(String reName) {
        this.reName = reName;
    }

    public String getReCategory() {
        return reCategory;
    }

    public void setReCategory(String reCategory) {
        this.reCategory = reCategory;
    }

    public String getRePrice() {
        return rePrice;
    }

    public void setRePrice(String rePrice) {
        this.rePrice = rePrice;
    }

    public String getReNumber() {
        return reNumber;
    }

    public void setReNumber(String reNumber) {
        this.reNumber = reNumber;
    }
}
