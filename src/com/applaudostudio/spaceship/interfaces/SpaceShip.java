package com.applaudostudio.spaceship.interfaces;

import com.applaudostudio.spaceship.entities.Item;

public interface SpaceShip {
    public boolean launch();
    public boolean land();
    public boolean canCarry(Item item);
    public boolean carry(Item item);
}



