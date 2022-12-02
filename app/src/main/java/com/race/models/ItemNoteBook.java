package com.race.models;

public class ItemNoteBook {
    int photo;
    String noteName;
    Double notePrice;

    public ItemNoteBook(int photo, String noteName, Double notePrice) {
        this.photo = photo;
        this.noteName = noteName;
        this.notePrice = notePrice;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public Double getNotePrice() {
        return notePrice;
    }

    public void setNotePrice(Double notePrice) {
        this.notePrice = notePrice;
    }

}
