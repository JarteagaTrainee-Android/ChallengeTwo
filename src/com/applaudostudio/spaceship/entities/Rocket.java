package com.applaudostudio.spaceship.entities;

import com.applaudostudio.spaceship.interfaces.SpaceShip;

public class Rocket implements SpaceShip {
    protected int cost;
    protected int weight;
    protected double maxWeight;
    protected double explosionChance;
    protected double crashChance;

    /***
     * Implementation of launch for the interface spaceship
     * @return always true
     */
    @Override
    public boolean launch() {
        return true;
    }

    /***
     * Implementation of land for the interface spaceship
     * @return always tru
     */
    @Override
    public boolean land() {
        return true;
    }

    /***
     * function to check if the rocket can carry a new item.
     * @param item Object of entity Item.
     * @return return a boolean
     */
    @Override
    public boolean canCarry(Item item) {
        return ((item.getWeight() / 1000) + weight) <= maxWeight;
    }

    /***
     * updates the value of the current weight for the rocket
     * @param item
     */
    @Override
    public void carry(Item item) {
        if (this.canCarry(item))
            this.weight += item.getWeight() / 1000;
    }


    public int getCost() {
        return cost;
    }

    /***
     * to get a random item if a event is going to fail
     * @return a value between 0 and 1 but no including 1
     */
    protected double failProbability() {
        return Math.random();
    }

}
