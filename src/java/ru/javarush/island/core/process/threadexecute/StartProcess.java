package ru.javarush.island.core.process.threadexecute;

import ru.javarush.island.core.process.logic.AnimalEating;
import ru.javarush.island.core.process.logic.MovementFauna;
import ru.javarush.island.core.process.logic.ReproductionFauna;
import ru.javarush.island.core.process.statistics.CollectStatistics;
import ru.javarush.island.core.process.statistics.PrintStatistics;
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


    /**
     * подкидываем таски на выполнение - вывод статистики + рост травы и запускаем логику животных
     * // сделать условия для окончания процесса + синхронизовать вывод - статистика + вывод острова
     * // при большом количестве ячеек, таски могут друг друга не ждать.
     */
    public void start() {
            island.builtIsland();
            island.CreateAnimalsOnIsland();

            ScheduledFuture<?> statisticPlusGrowPlants = sesStatistic.scheduleAtFixedRate(printStatistics, 1, 1, TimeUnit.SECONDS);
            ScheduledFuture<?> simulateLife =             sesSimulateLife.scheduleAtFixedRate(lifeActions, 1, 1, TimeUnit.SECONDS);

        }
    }

