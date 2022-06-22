package ru.javarush.island;

public class SimulateLifeActions implements Runnable {


    private final Island map;

    public SimulateLifeActions(Island map) {
        this.map = map;
    }

    @Override
    public void run() {
        for (int x = 0; x < map.getHEIGHT(); x++) {
            for (int y = 0; y < map.getWIDTH(); y++) {
                Cell cell = map.getIslandMap()[x][y];






            }
        }
    }
}
