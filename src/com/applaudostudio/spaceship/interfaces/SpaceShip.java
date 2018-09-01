package com.applaudostudio.spaceship.interfaces;

import com.applaudostudio.spaceship.entities.Item;

/***
 * Interface to be implemented in the class Rocket
 */
public interface SpaceShip {
    /***
     * function to check if the launch was completed by the rocket
     * @return
     */
    boolean launch();
    /***
     * function to check if the landing phase was completed by the rocket
     * @return
     */
    boolean land();

    /***
     * function to check if its the rocket can carry with a new item
     * @return
     */
    boolean canCarry(Item item);

    /***
     * function update the value of the weight for a rocket
     * @return
     */
    void carry(Item item);
}



