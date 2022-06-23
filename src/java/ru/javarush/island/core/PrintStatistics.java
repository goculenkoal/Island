package ru.javarush.island.core;

import ru.javarush.island.island.Island;

public class PrintStatistics implements Runnable {
    private Island map;

    public PrintStatistics(Island map) {
        this.map = map;
    }

    CollectStatistics collectStatistics = new CollectStatistics(map);

    @Override
    public void run() {

    }
}
