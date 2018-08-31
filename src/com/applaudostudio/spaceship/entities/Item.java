package com.applaudostudio.spaceship.entities;

public class Item {
    private String mName;
    private int mWeight;
    private  boolean  mLoad;

    public Item() {
        this.mLoad =false;
    }

    public void setLoad() {
        this.mLoad = true;
    }

    public boolean isLoad() {
        return mLoad;
    }


    public void setName(String mName) {
        this.mName = mName;
    }

    int getWeight() {
        return mWeight;
    }

    public void setWeight(int mWeight) {
        this.mWeight = mWeight;
    }


}
