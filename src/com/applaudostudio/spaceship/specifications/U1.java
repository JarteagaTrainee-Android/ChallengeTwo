package com.applaudostudio.spaceship.specifications;

import com.applaudostudio.spaceship.entities.Rocket;

public class U1 extends Rocket {
    /*
     * Rocket cost = $100 Million
     * Rocket weight = 10 Tonnes
     * Max weight (with cargo) = 18 Tonnes
     * Chance of launch explosion = 5% * (cargo carried / cargo limit)
     * Chance of landing crash = 1% * (cargo carried / cargo limit)
     */

    /***
     * constructor to set the init specifications for a U1 rocket
     */
    public U1() {
        cost = 100000000;
        weight = 10;
        maxWeight = 18.0;
    }

    /***
     * function to set check if the launch was success
     */
    @Override
    public boolean launch() {
        explosionChance = 0.0;
        explosionChance = 0.05 * ((weight - 10) / (maxWeight));
        double event = this.failProbability();
        return explosionChance <= event*100;
    }

    /***
     * function to set check if the landing was success
     */
    @Override
    public boolean land() {
        crashChance = 0.01 * ((weight - 10) / (maxWeight));
        double event = this.failProbability();
        return crashChance*100 <= event*100;
    }
}
