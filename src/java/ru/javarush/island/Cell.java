package ru.javarush.island;

import ru.javarush.island.creatures.Animal;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private int axisX;
    private int axisY;
    /** массив объектов Animal находящихся в этой ячейке */
    private List<Animal> allAnimalInCell = new ArrayList<>();

    /**
     * Инициализация координат ячейки на острове
     * @param x -ось х
     * @param y - ось у
     */
    public Cell(int x, int y) {
        this.axisX = x;
        this.axisY = y;
    }

    public void addAnimal(Animal animal) {
        allAnimalInCell.add(animal);
    }

    public List<Animal> getAllAnimalInCell() {
        return allAnimalInCell;
    }

    @Override
    public String toString() {
        return "[" +
                "x:" + axisX +
                ", y:" + axisY + "->" + getAllAnimalInCell() +
                ']';
    }
}
