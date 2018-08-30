package com.applaudostudio.spaceship.entities;

public class Item {
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmWeight() {
        return mWeight;
    }

    public void setmWeight(int mWeight) {
        this.mWeight = mWeight;
    }

    public Item(String mName, int mWeight) {
        this.mName = mName;
        this.mWeight = mWeight;
    }

    public Item() {
    }

    private String mName;
    private int mWeight;

}
