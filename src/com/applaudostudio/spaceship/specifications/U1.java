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


    public U1() {
        cost=100000000;
        weight=10;
        maxWeight = 18.0;
    }


    @Override
    public boolean launch() throws NullPointerException{
        explosionChance=0.0;
            explosionChance = 0.05 * ((weight - 10) / (maxWeight));
        return explosionChance >= this.eventProbability();
    }

    @Override
    public boolean land() throws NullPointerException {
        crashChance = 0.01 * ((weight - 10) / (maxWeight));
            System.out.println("Error on Landing");
            explosionChance=100.0;
        return explosionChance >= this.eventProbability();
    }
}
