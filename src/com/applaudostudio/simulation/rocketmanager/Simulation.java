package com.applaudostudio.simulation.rocketmanager;

import com.applaudostudio.simulation.reader.TextFileReader;
import com.applaudostudio.spaceship.entities.Item;
import com.applaudostudio.spaceship.specifications.U1;
import com.applaudostudio.spaceship.specifications.U2;

import java.util.*;

public class Simulation {

    /***
     * aux function to change the plain text lines of a file to a list of Items
     * @param phaseName name of the file as string
     * @return returns a list of items
     */
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

    /***
     * Function to check if there is still items out of the rockets
     * @param itemList list of items as parameter
     * @return returns the number of items left
     */
    private int itemsLeft(List<Item> itemList) {
        int counter = 0;
        for (Item item : itemList) {
            if (!item.isLoad()) {
                counter++;
            }
        }
        return counter;
    }

    /***
     * function to generate a QUEUE of rockets to be launch
     * @param itemsList list of items to sent
     * @return return a queue of rockts U1
     */
    private Queue<U1> loadU1(List<Item> itemsList) {
        Queue<U1> queueReadyToFly = new LinkedList<>();
        U1 spaceShip;
        do {
            spaceShip = new U1();
            for (Item item : itemsList) {
                if (spaceShip.canCarry(item) && !item.isLoad()) {
                    spaceShip.carry(item);
                    item.setLoad();
                }
            }
            queueReadyToFly.add(spaceShip);
        } while (this.itemsLeft(itemsList) > 0);

        return queueReadyToFly;
    }

    /***
     * function to generate a QUEUE of rockets to be launch
     * @param itemsList list of items to sent
     * @return return a queue of rockts U2
     */
    private Queue<U2> loadU2(List<Item> itemsList) {
        Queue<U2> queueReadyToFly = new LinkedList<>();
        U2 spaceShip;
        do {
            spaceShip = new U2();
            for (Item item : itemsList) {
                if (spaceShip.canCarry(item) && !item.isLoad()) {
                    spaceShip.carry(item);
                    item.setLoad();
                }

            }
            queueReadyToFly.add(spaceShip);
        } while (this.itemsLeft(itemsList) > 0);

        return queueReadyToFly;
    }

    /***
     * Function to display a menu of phases for each kind of rocket.
     * @param rocketKind kind of rocket 1 for U1 and 2 for U2 rockets
     * @param rocketsU1Queue Queue of U1 Rockets ready to fly
     * @param rocketsU2Queue Queue of U2 Rockets ready to fly
     * @return returns a double of withe amount in $ to spend in the mission.
     */
    private double phaseExecution(int rocketKind, Queue<U1> rocketsU1Queue, Queue<U2> rocketsU2Queue) {
        int result = 0;
        switch (rocketKind) {
            case 1:
                do {
                    U1 testRocketU1 = rocketsU1Queue.poll();
                    try {
                        assert testRocketU1 != null;
                        if (testRocketU1.launch()) {
                            if (testRocketU1.land()) {
                                result += testRocketU1.getCost();
                            } else {
                                rocketsU1Queue.add(testRocketU1);
                                result += testRocketU1.getCost();
                            }
                        } else {
                            result += testRocketU1.getCost();
                            rocketsU1Queue.add(testRocketU1);
                        }
                    } catch (NullPointerException ex) {
                        System.out.println("Error on simulation with rockets U1");
                    }
                } while (rocketsU1Queue.size() > 0);
                break;
            case 2:
                do {
                    U2 testRocketU2 = rocketsU2Queue.poll();
                    try {
                        assert testRocketU2 != null;
                        if (testRocketU2.launch()) {
                            if (testRocketU2.land()) {
                                result += testRocketU2.getCost();
                            } else {
                                rocketsU2Queue.add(testRocketU2);
                                result += testRocketU2.getCost();
                            }
                        } else {
                            result += testRocketU2.getCost();
                            rocketsU2Queue.add(testRocketU2);
                        }
                    } catch (NullPointerException ex) {
                        System.out.println("Error on simulation with rockets U2");
                    }
                } while (rocketsU2Queue.size() > 0);
                break;
        }
        return result;
    }

    /***
     * Function to execute the simulation of each phase,  to the menu.
     * @param rocketType parameter to identify the rocket type
     * @param rocketsU1Queue queue of the rockets U1 for phase 1
     * @param rocketsU1P2Queue queue of the rockets U1 for the phase 2
     * @param rocketsU2Queue queue of the rockets U2 for the phase 1
     * @param rocketsU2P2Queue queue of the rockets U2 for the phase 2
     * @return return the amount in dollars for the full simulation of a kind of rocket
     */
    private Double phasesMenu(int rocketType, Queue<U1> rocketsU1Queue, Queue<U1> rocketsU1P2Queue, Queue<U2> rocketsU2Queue, Queue<U2> rocketsU2P2Queue) {
        int phaseSelector;
        double totalCostPh1 = 0;
        double totalCostPh2 = 0;
        boolean backToMainMenu = false;
        Scanner scanner;
        scanner = new Scanner(System.in);
        do {
            System.out.println("Please choose a Phase to execute");
            System.out.println("1. Phase 1");
            System.out.println("2. Phase 2");
            System.out.println("3. Show Results");
            System.out.println("4. Back <--;");
            System.out.println("Please Insert a Number");
            phaseSelector = Integer.parseInt(scanner.nextLine());
            switch (phaseSelector) {
                case 1:
                    totalCostPh1 = this.phaseExecution(rocketType, rocketsU1Queue, rocketsU2Queue);
                    System.out.println("Phase 1 complete");
                    break;
                case 2:
                    totalCostPh2 = this.phaseExecution(rocketType, rocketsU1P2Queue, rocketsU2P2Queue);
                    System.out.println("Phase 2 complete");

                    break;
                case 3:
                    if (totalCostPh1 == 0 || totalCostPh2 == 0) {
                        System.out.println("Please complete the phase 1 and phase 2 for this kind of rocket");
                    }
                    System.out.println("Total cost of phase1: " + totalCostPh1);
                    System.out.println("Total cost of phase2: " + totalCostPh2);
                    System.out.println("You'll need $" + (totalCostPh1 + totalCostPh2) + "To complete the mission");
                    break;
                case 4:
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("invalid option, back to My menu");
                    backToMainMenu = true;
            }
        } while (!backToMainMenu);
        return totalCostPh1 + totalCostPh2;
    }

    /***
     * Main procedure to call all the simulation functions.
     */
    public void runSimulation() {
        Queue<U1> u1P1ReadyToFly;
        Queue<U1> u1P2ReadyToFly;
        Queue<U2> u2P1ReadyToFly;
        Queue<U2> u2P2ReadyToFly;
        Scanner scanner;
        int rocketTypeSelector;
        boolean endSimulation = false;
        double totalRocket1 = 0;
        double totalRocket2 = 0;


        System.out.println("Generating rockets for phase 1");
        u1P1ReadyToFly = this.loadU1(this.loadItems("src/phase-1.txt"));
        u2P1ReadyToFly = this.loadU2(this.loadItems("src/phase-1.txt"));
        System.out.println("Rockets for phase 1 ready to launch");
        System.out.println("Generatin Rockets for Phase 2");
        u1P2ReadyToFly = this.loadU1(this.loadItems("src/phase-2.txt"));
        u2P2ReadyToFly = this.loadU2(this.loadItems("src/phase-2.txt"));
        System.out.println("Rockets for phase 2 ready to launch");


        System.out.println(u1P1ReadyToFly.size());
        System.out.println(u1P2ReadyToFly.size());
        System.out.println(u2P1ReadyToFly.size());
        System.out.println(u2P2ReadyToFly.size());


        do {
            System.out.println("*********** Simulation Control ************");
            System.out.println("Choose the SpaceShip to test");
            System.out.println("1. Spaceship type U1");
            System.out.println("2. Spaceship type U2");
            System.out.println("3. Show Final Results");
            System.out.println("4. Exit");
            System.out.println("Choose and Option");
            scanner = new Scanner(System.in);
            rocketTypeSelector = Integer.parseInt(scanner.nextLine());
            switch (rocketTypeSelector) {
                case 1:
                    totalRocket1 = this.phasesMenu(1, u1P1ReadyToFly, u1P2ReadyToFly, u2P1ReadyToFly, u2P2ReadyToFly);
                    break;
                case 2:
                    totalRocket2 = this.phasesMenu(2, u1P1ReadyToFly, u1P2ReadyToFly, u2P1ReadyToFly, u2P2ReadyToFly);
                    break;
                case 3:
                    if (totalRocket1 == 0 || totalRocket2 == 0) {
                        System.out.println("You need to complete the 2 phases1 for both kind of rockets");
                    } else {
                        System.out.println("Total money for U1 Rockets: " + totalRocket1);
                        System.out.println("Total money for U2 Rockets: " + totalRocket2);
                        if (totalRocket1 > totalRocket2) {
                            System.out.println("In this simulation is better to use rockets U2: " + totalRocket2);
                        } else {
                            System.out.println("In this simulation is better to use rockets U1: 1" + totalRocket1);
                        }
                    }
                    break;
                case 4:
                    endSimulation = true;
                    break;
                default:
                    System.out.println("Invalid Option");
                    endSimulation = false;
                    break;
            }

        } while (!endSimulation);

    }


}
