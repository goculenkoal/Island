package ru.javarush.island.core;

import ru.javarush.island.core.*;
import ru.javarush.island.island.Island;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class StartProcess {
    Island island = new Island();
    MovementFauna movementFauna = new MovementFauna(island);
    ReproductionFauna reproductionFauna = new ReproductionFauna(island);
    AnimalEating animalEating = new AnimalEating();
    SimulateLifeActions lifeActions = new SimulateLifeActions(island,movementFauna, reproductionFauna,animalEating);
    CollectStatistics collectStatistics = new CollectStatistics(island);
    PrintStatistics printStatistics = new PrintStatistics(island, collectStatistics);
    ScheduledExecutorService sesStatistic = Executors.newScheduledThreadPool(1);
    ScheduledExecutorService sesSimulateLife = Executors.newScheduledThreadPool(2);

        public void start() {
            island.builtIsland();
            island.fillupd();

            ScheduledFuture<?> sF = sesStatistic.scheduleAtFixedRate(printStatistics, 0, 1, TimeUnit.SECONDS);
            ScheduledFuture<?> simulateLife = sesSimulateLife.scheduleAtFixedRate(lifeActions, 0, 1, TimeUnit.SECONDS);
        }






    }

