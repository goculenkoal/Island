package ru.javarush.island.core;

import ru.javarush.island.creatures.Animal;
import ru.javarush.island.creatures.flora.Plant;
import ru.javarush.island.island.Cell;
import ru.javarush.island.island.Island;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectStatistics {
    private Island map;

    public CollectStatistics(Island map) {
        this.map = map;
    }

    public void StatisticsViewer() { // Статистика
        Map<String, Integer> collectAnimalPlantStats = new ConcurrentHashMap<>();
        for (int x = 0; x < map.getHEIGHT(); x++) {
            for (int y = 0; y < map.getWIDTH(); y++) {
                Cell cell = map.getIslandMap()[x][y];
                List<Animal> animals = cell.getAllAnimalInCell();
                List<Plant> plants = cell.getAllPlantInCell();
                Map<String, Integer> collect =
                        Stream.of(animals, plants).flatMap(Collection::stream).collect(Collectors.toMap(Object::toString, e -> 1, Integer::sum));
                collect.forEach((k, v) -> collectAnimalPlantStats.merge(k, v, Integer::sum));
            }

        }
        System.out.print("[ " +collectAnimalPlantStats + " ]");

    }


}
