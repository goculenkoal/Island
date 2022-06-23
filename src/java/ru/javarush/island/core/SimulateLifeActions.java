package ru.javarush.island.core;

import ru.javarush.island.island.Cell;
import ru.javarush.island.island.Island;

public class SimulateLifeActions implements Runnable {
    Island map1;
    MovementFauna movementFauna = new MovementFauna(map1);
    ReproductionFauna reproductionFauna = new ReproductionFauna(map1);
    AnimalEating animalEating = new AnimalEating();
    CollectStatistics collectStatistics = new CollectStatistics(map1);

    public SimulateLifeActions(Island map1) {
        this.map1 = map1;
    }

    @Override
    public void run() {
        for (int x = 0; x < map1.getHEIGHT(); x++) {
            for (int y = 0; y < map1.getWIDTH(); y++) {
                Cell cell = map1.getIslandMap()[x][y];

               movementFauna.doMove(cell);
               animalEating.eatAllAnimals(cell);
               reproductionFauna.multiply(cell);
               cell.generatePlants();
               cell.resetWalkStatus(cell);
            }
        }
        map1.islandViewer();
        System.out.println("Stats");
        collectStatistics.StatisticsViewer();
    }

    public void initialiseIsland() {
        map1.builtIsland();
        map1.fillupd();
        //map1.islandViewer();
        System.out.println();
       //collectStatistics.islandViewer();
    }
}
