package com.applaudostudio.spaceship.specifications;

public class U2 {
    /*
    * Rocket cost = $120 Million
    * Rocket weight = 18 Tonnes
    * Max weight (with cargo) = 29 Tonnes
    * Chance of launch explosion = 4% * (cargo carried / cargo limit)
    * Chance of landing crash = 8% * (cargo carried / cargo limit)
    */
    private final int cost;
    private final int weight;
    private final int maxWeight;
    private double explotionChance;
    private double crashChance;

    public U2() {
        cost=120000000;
        weight=18;
        maxWeight = 18;
    }



}
