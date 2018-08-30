package com.applaudostudio.spaceship.specifications;

public class U1 {
  /*
  * Rocket cost = $100 Million
  * Rocket weight = 10 Tonnes
  * Max weight (with cargo) = 18 Tonnes
  * Chance of launch explosion = 5% * (cargo carried / cargo limit)
  * Chance of landing crash = 1% * (cargo carried / cargo limit)
  */
    private final int cost;
    private final int weight;
    private final int maxWeight;


    private double explotionChance;
    private double crashChance;
    public U1() {
        cost=100000000;
        weight=10;
        maxWeight = 18;
    }



}
