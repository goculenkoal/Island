package ru.javarush.island;

import ru.javarush.island.creatures.Animal;
import ru.javarush.island.creatures.Predator;
import ru.javarush.island.creatures.Prey;
import ru.javarush.island.creatures.flora.Plant;
import ru.javarush.island.creatures.preditor.Wolf;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cell {

    private int axisX;
    private int axisY;
    /** массив объектов Animal находящихся в этой ячейке */
    private List<Animal> allAnimalInCell = new CopyOnWriteArrayList<>();
    private List<Plant> allPlantInCell = new CopyOnWriteArrayList<>();
    /**
     * Инициализация координат ячейки на острове
     * @param x -ось х
     * @param y - ось у
     */
    public Cell(int x, int y) {
        this.axisX = x;
        this.axisY = y;
    }

    public Cell() {

    }

    public int getAxisX() {
        return axisX;
    }
    public int getAxisY() {
        return axisY;
    }

    public void addAnimal(Animal animal) {
        allAnimalInCell.add(animal);
    }

    public void deleteAnimal(Animal animal){
        allAnimalInCell.remove(animal);
    }

    public List<Plant> getAllPlantInCell() {
        return allPlantInCell;
    }

    public List<Animal> getAllAnimalInCell() {
        return allAnimalInCell;
    }


    /**
     * Считаем количество животных в ячейке
     * @param animal - принимаем животное
     * @return количество особей в ячейке,если нет - возвращаем ноль.
     */
    public int getCountAnimalInCell(Animal animal) {
        //System.out.println(animal.getClass().getSimpleName());

        Map<Object, Integer> collect = Stream.of(allAnimalInCell).flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Object::toString, e -> 1, Integer::sum));
        if(collect.get(animal.toString()) == null) {
            return 0;
        } else {
            return collect.get(animal.toString());
        }
    }

    public void generatePlants(Cell cell) {
        Plant plant = new Plant();
        for (int k = 0; k < ThreadLocalRandom.current().nextInt(plant.getMaxOnCell() + 1); k++)
            cell.getAllPlantInCell().add((plant));

    }

    @Override
    public String toString() {
        return "[" +
                "x:" + axisX +
                ", y:" + axisY + "->" + getAllAnimalInCell() + getAllPlantInCell() +  //Arrays.toString(Population.values()
                ']';
    }
}
