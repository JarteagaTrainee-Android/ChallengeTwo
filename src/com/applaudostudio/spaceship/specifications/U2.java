package com.applaudostudio.spaceship.specifications;

import com.applaudostudio.spaceship.entities.Rocket;

public class U2 extends Rocket {
    /*
     * Rocket cost = $120 Million
     * Rocket weight = 18 Tonnes
     * Max weight (with cargo) = 29 Tonnes
     * Chance of launch explosion = 4% * (cargo carried / cargo limit)
     * Chance of landing crash = 8% * (cargo carried / cargo limit)
     */


    /***
     * constructor to set the init specifications for a U1 rocket
     */
    public U2() {
        cost = 120000000;
        weight = 18;
        maxWeight = 29.0;
    }

    /***
     * function to set check if the launch was success
     */
    @Override
    public boolean launch() {
        explosionChance = 0.04 * ((weight - 18) / (maxWeight));
        double event = this.failProbability();
        return explosionChance <= event * 100;
    }

    /***
     * function to set check if the landing was success
     */
    @Override
    public boolean land() {
        crashChance = 0.08 * ((weight - 18) / (maxWeight));
        double event = this.failProbability();
        return crashChance * 100 <= event * 100;
    }

}
