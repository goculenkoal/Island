package ru.javarush.island.core.process.statistics;

import ru.javarush.island.island.Island;

public class PrintStatistics implements Runnable {
    private final Island map;
    CollectStatistics collectStatistics;

    public PrintStatistics(Island map, CollectStatistics collectStatistics) {
        this.map = map;
        this.collectStatistics = collectStatistics;
    }

    @Override
    public void run() {
        System.out.println();
        System.out.print("Статистика: ");
        collectStatistics.StatisticsViewer();
        System.out.println();
    }
}
