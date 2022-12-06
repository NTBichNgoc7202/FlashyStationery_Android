package com.race.models;

public class PaymentMethod {
    int mePhoto;
    String meTitle, meDes;

    public PaymentMethod(int mePhoto, String meTitle, String meDes) {
        this.mePhoto = mePhoto;
        this.meTitle = meTitle;
        this.meDes = meDes;
    }

    public int getMePhoto() {
        return mePhoto;
    }

    public void setMePhoto(int mePhoto) {
        this.mePhoto = mePhoto;
    }

    public String getMeTitle() {
        return meTitle;
    }

    public void setMeName(String meTitle) {
        this.meTitle = meTitle;
    }

    public String getMeDes() {
        return meDes;
    }

    public void setMeDes(String meDes) {
        this.meDes = meDes;
    }
}
