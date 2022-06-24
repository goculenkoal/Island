package ru.javarush.island.core.process.threadexecute;

import ru.javarush.island.core.process.logic.AnimalEating;
import ru.javarush.island.core.process.logic.MovementFauna;
import ru.javarush.island.core.process.logic.ReproductionFauna;
import ru.javarush.island.island.Cell;
import ru.javarush.island.island.Island;

import java.util.concurrent.atomic.AtomicInteger;

public class SimulateLifeActions implements Runnable {
    private static final AtomicInteger id = new AtomicInteger(0);
    private final Island map;
    MovementFauna movementFauna;
    ReproductionFauna reproductionFauna;
    AnimalEating animalEating;

    public SimulateLifeActions(Island map, MovementFauna movementFauna, ReproductionFauna reproductionFauna, AnimalEating animalEating) {
        this.map = map;
        this.movementFauna = movementFauna;
        this.reproductionFauna = reproductionFauna;
        this.animalEating = animalEating;

    }

    public static AtomicInteger getId() {
        return id;
    }

    @Override
    public void run() {
        id.getAndIncrement();
        for (int x = 0; x < map.getHEIGHT(); x++) {
            for (int y = 0; y < map.getWIDTH(); y++) {
                Cell cell = map.getIslandMap()[x][y];

                   animalEating.eatAllAnimals(cell);
                   movementFauna.doMove(cell);
                   reproductionFauna.multiply(cell);
                   cell.generatePlants();
                   cell.resetWalkStatus();
            }
        }
        System.out.println("Turn " + getId());
        map.islandViewer();
    }
}
