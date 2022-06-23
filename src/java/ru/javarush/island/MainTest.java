package ru.javarush.island;

import ru.javarush.island.core.*;
import ru.javarush.island.island.Island;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public static void main(String[] args) {
        Island island = new Island();
        MovementFauna movementFauna = new MovementFauna(island);
        ReproductionFauna reproductionFauna = new ReproductionFauna(island);
        AnimalEating animalEating = new AnimalEating();
        SimulateLifeActions lifeActions = new SimulateLifeActions(island,movementFauna, reproductionFauna,animalEating);
        CollectStatistics collectStatistics = new CollectStatistics(island);
        PrintStatistics printStatistics = new PrintStatistics(island, collectStatistics);
        island.builtIsland();
        island.fillupd();

        ScheduledExecutorService sesStatictic = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService sesSimulateLife = Executors.newScheduledThreadPool(2);


        ScheduledFuture<?> sF = sesStatictic.scheduleAtFixedRate(printStatistics, 0, 1, TimeUnit.SECONDS);
        ScheduledFuture<?> simulateLife = sesSimulateLife.scheduleAtFixedRate(lifeActions, 0, 1, TimeUnit.SECONDS);


    }
}
