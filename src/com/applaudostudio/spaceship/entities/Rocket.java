package com.applaudostudio.spaceship.entities;

import com.applaudostudio.spaceship.interfaces.SpaceShip;

public class Rocket implements SpaceShip {
    protected int cost;
    protected int weight;
    protected double maxWeight;

    protected double explosionChance;
    protected double crashChance;


    public int getCost() {
        return cost;
    }

    protected double eventProbability() {
        return Math.random();
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return ((item.getWeight() / 1000) + weight) <= maxWeight;
    }

    @Override
    public boolean carry(Item item) {
        if (this.canCarry(item))
            this.weight += item.getWeight() / 1000;
        return false;
    }


}
