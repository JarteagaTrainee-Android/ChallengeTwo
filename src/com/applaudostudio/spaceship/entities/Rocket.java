package com.applaudostudio.spaceship.entities;

import com.applaudostudio.spaceship.interfaces.SpaceShip;

public class Rocket implements SpaceShip {




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
        return false;
    }

    @Override
    public boolean carry(Item item) {
        return false;
    }


}
