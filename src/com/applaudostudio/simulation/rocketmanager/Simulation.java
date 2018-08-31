package com.applaudostudio.simulation.rocketmanager;

import com.applaudostudio.simulation.reader.TextFileReader;
import com.applaudostudio.spaceship.entities.Item;
import com.applaudostudio.spaceship.specifications.U1;
import com.applaudostudio.spaceship.specifications.U2;

import java.util.*;

public class Simulation {
    private List<Item> loadItems(String phaseName) {
        List<Item> resultListOfItems = new ArrayList<>();
        TextFileReader reader = new TextFileReader(phaseName);
        for (String itemString : reader.getItemsText()) {
            Item item = new Item();
            String[] parts = itemString.split("=");
            item.setName(parts[0]);
            item.setWeight(Integer.parseInt(parts[1]));
            resultListOfItems.add(item);
        }
        return resultListOfItems;
    }

    private int itemsLeft(List<Item> itemList) {
        int counter = 0;
        for (Item item : itemList) {
            if (item.isLoad()) {
                counter++;
            }
        }
        return counter;
    }

    private Queue<U1> loadU1(List<Item> itemsList) {
        Queue<U1> queueReadyToFly = new LinkedList();
        U1 spaceShip;
        do {
            spaceShip = new U1();
            for (Item item : itemsList) {
                if (spaceShip.canCarry(item) && item.isLoad()) {
                    spaceShip.carry(item);
                    item.setLoad();
                }

            }
            queueReadyToFly.add(spaceShip);
        } while (this.itemsLeft(itemsList) > 0);

        return queueReadyToFly;
    }


    private Queue<U2> loadU2(List<Item> itemsList) {
        Queue<U2> queueReadyToFly = new LinkedList();
        U2 spaceShip;
        do {
            spaceShip = new U2();
            for (Item item : itemsList) {
                if (spaceShip.canCarry(item) && item.isLoad()) {
                    spaceShip.carry(item);
                    item.setLoad();
                }

            }
            queueReadyToFly.add(spaceShip);
        } while (this.itemsLeft(itemsList) > 0);

        return queueReadyToFly;
    }


    public void runSimulation() {
        Queue<U1> u1P1ReadyToFly;
        Queue<U1> u1P2ReadyToFly;

        Queue<U2> u2P1ReadyToFly;
        Queue<U2> u2P2ReadyToFly;
        Scanner scanner;
        Integer phaseSelector;
        Boolean endSimulation = false;


        System.out.println("Generating rockets for phase 1");
        u1P1ReadyToFly = this.loadU1(this.loadItems("src/phase-1.txt"));
        u2P1ReadyToFly = this.loadU2(this.loadItems("src/phase-1.txt"));
        System.out.println("Rockets for phase 1 ready to launch");
        System.out.println("Generatin Rockets for Phase 2");
        u1P2ReadyToFly = this.loadU1(this.loadItems("src/phase-2.txt"));
        u2P2ReadyToFly = this.loadU2(this.loadItems("src/phase-2.txt"));
        System.out.println("Rockets for phase 2 ready to launch");
        do {
            System.out.println("*********** Simulation Control ************");
            System.out.println("Choose the phase to test");
            System.out.println("1. Phase 1");
            System.out.println("2. Phase 2");
            System.out.println("3. Exit");
            System.out.println("Choose and Option");
            scanner = new Scanner(System.in);
            phaseSelector = Integer.parseInt(scanner.nextLine());
            switch (phaseSelector) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    endSimulation = true;
                    break;
                default:
                    System.out.println("Invalid Option");
                    endSimulation = false;
                    break;
            }

        } while (!endSimulation);

    }

    private double phaseExecution(int rocketKind, Queue<U1> rocketsU1Queue, Queue<U2> rocketsU2Queue){
        int result = 0;
        switch (rocketKind){
            case 1:
                Queue u1InLaunched = new LinkedList();
                do{
                    U1 testRocketu1 = rocketsU1Queue.poll();
                    try {
                        assert testRocketu1 != null;
                        if(testRocketu1.launch()){
                       u1InLaunched.add(testRocketu1);
                       result+=testRocketu1.getCost();
                    }else{
                        rocketsU1Queue.add(testRocketu1);
                        result+=testRocketu1.getCost();
                    }
                    }catch (NullPointerException ex){
                        System.out.println("Error on simulation with rockets U1");
                    }
                }while(u1InLaunched.size()>0 && rocketsU1Queue.size()<0);
                break;
            case 2:

                break;
        }




        return result;
    }

}
