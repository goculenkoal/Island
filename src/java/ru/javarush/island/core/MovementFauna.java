package ru.javarush.island.core;

import ru.javarush.island.island.Cell;
import ru.javarush.island.island.Island;
import ru.javarush.island.creatures.Animal;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MovementFauna {
    /**
     * Поле карта острова для передвижения
     */
    private Island map;



    /** Передача в конструктор движения животных карты острова*/
    public MovementFauna(Island map) {
        this.map = map;
    }

    /**
     * Движение всех животных в ячейке
     * @param cell - ячейка острова
     */
    public void doMove(Cell cell) {
                int x = cell.getAxisX();
                int y = cell.getAxisY();
                List<Animal> listAnimal = cell.getAllAnimalInCell();// ячейка по координатам
                if (!listAnimal.isEmpty()) {
                    for (Animal animal : listAnimal) {
                        while (!animal.isMoved() && animal.getMoveSpeed() != 0) {
                            int speed = ThreadLocalRandom.current().nextInt(animal.getMoveSpeed() + 1);
                            int direction = ThreadLocalRandom.current().nextInt(5);

                            if (speed <= 0) {
                                animal.setIsMoved(true);
                                break;

                            }

                            if (direction == Settings.DOWN) {
                                if (x + speed < map.getHEIGHT() - 1) {
                                    Cell newCell = map.getIslandMap()[x + speed][y];
                                    if(newCell.getCountAnimalInCell(animal) < animal.getMaxPopulationOnCell()) {
                                        newCell.addAnimal(animal);
                                        animal.setIsMoved(true);
                                        cell.deleteAnimal(animal);
                                    }

                                }
                            }
                            if (direction == Settings.UP) { // вверх
                                if (x - speed > 0) {
                                    Cell newCell = map.getIslandMap()[x - speed][y];
                                    if(newCell.getCountAnimalInCell(animal) < animal.getMaxPopulationOnCell()) {
                                        animal.setIsMoved(true);
                                        newCell.addAnimal(animal);
                                        cell.deleteAnimal(animal);
                                    }
                                }
                            }
                            if (direction == Settings.RIGHT) { //вправо
                                if (y + speed < map.getWIDTH() - 1) {
                                    Cell newCell = map.getIslandMap()[x][y + speed];
                                    if(newCell.getCountAnimalInCell(animal) < animal.getMaxPopulationOnCell()) {
                                        newCell.addAnimal(animal);
                                        animal.setIsMoved(true);
                                        cell.deleteAnimal(animal);
                                    }
                                }
                            }
                            if (direction == Settings.LEFT) { //влево
                                if (y - speed > 0) {
                                    Cell newCell = map.getIslandMap()[x][y - speed];
                                    if(newCell.getCountAnimalInCell(animal) < animal.getMaxPopulationOnCell()) {
                                        animal.setIsMoved(true);
                                        newCell.addAnimal(animal);
                                        cell.deleteAnimal(animal);
                                    }
                                }
                            }
                        }
                    }
                }
    }
}

