package com.applaudostudio.spaceship.entities;

/***
 * Entity for items to be load to a spaceship
 */
public class Item {
    private String mName;
    private int mWeight;
    private boolean mLoad;

    public Item() {
        this.mLoad = false;
    }

    /***
     * function to set an items as load
     */
    public void setLoad() {
        this.mLoad = true;
    }

    /***
     * to check if the item is already in a spaceship
     */
    public boolean isLoad() {
        return mLoad;
    }

    /***
     * set a name of item
     * @param mName
     */
    public void setName(String mName) {
        this.mName = mName;
    }

    /***
     * function to get the weight of an item
     * @return
     */
    int getWeight() {
        return mWeight;
    }

    public void setWeight(int mWeight) {
        this.mWeight = mWeight;
    }


}
