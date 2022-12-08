package com.race.models;

public class HotProduct {
    int prophoto;
    String hotName, hotAmount;
    Double hotPrice;

    public HotProduct(int prophoto, String hotName, String hotAmount, Double hotPrice) {
        this.prophoto = prophoto;
        this.hotName = hotName;
        this.hotAmount = hotAmount;
        this.hotPrice = hotPrice;
    }

    public int getProphoto() {
        return prophoto;
    }

    public void setProphoto(int prophoto) {
        this.prophoto = prophoto;
    }

    public String getHotName() {
        return hotName;
    }

    public void setHotName(String hotName) {
        this.hotName = hotName;
    }

    public String getHotAmount() {
        return hotAmount;
    }

    public void setHotAmount(String hotAmount) {
        this.hotAmount = hotAmount;
    }

    public Double getHotPrice() {
        return hotPrice;
    }

    public void setHotPrice(Double hotPrice) {
        this.hotPrice = hotPrice;
    }
}
