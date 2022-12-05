package com.race.models;

public class ItemModel {
    int modelPhoto;
    String modelNo;

    public ItemModel(int modelPhoto, String modelNo) {
        this.modelPhoto = modelPhoto;
        this.modelNo = modelNo;
    }

    public int getModelPhoto() {
        return modelPhoto;
    }

    public void setModelPhoto(int modelPhoto) {
        this.modelPhoto = modelPhoto;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }
}
