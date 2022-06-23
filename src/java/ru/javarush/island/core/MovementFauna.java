package ru.javarush.island.core;

import ru.javarush.island.island.Cell;
import ru.javarush.island.island.Island;
import ru.javarush.island.creatures.Animal;

import java.util.*;

public class MovementFauna {
    /**
     * Поле карта острова для передвижения
     */
    private Island map;

    /** Передача в конструктор движения животных карты острова*/
    public MovementFauna(Island map) {
        this.map = map;
    }

    public void doMove(Cell cell) {
                int x = cell.getAxisX();
                int y = cell.getAxisY();
                List<Animal> listAnimal = cell.getAllAnimalInCell();// ячейка по координатам
                if (!listAnimal.isEmpty()) {
                    for (Animal animal : listAnimal) {
                        while (!animal.isMoved() && animal.getMoveSpeed() != 0) {
                            int speed = new Random().nextInt(animal.getMoveSpeed() + 1);
                            int direction = new Random().nextInt(5);

                            if (speed <= 0) {
                                animal.setIsMoved(true);
                                break;

                            }

                            if (direction == 1) { //вниз
                                if (x + speed < map.getHEIGHT() - 1) {
                                    Cell newCell = map.getIslandMap()[x + speed][y];
                                    if(newCell.getCountAnimalInCell(animal) < animal.getMaxPopulationOnCell()) {
                                        newCell.addAnimal(animal);
                                        animal.setIsMoved(true);
                                        cell.deleteAnimal(animal);
                                    }

                                }
                            }
                            if (direction == 2) { // вверх
                                if (x - speed > 0) {
                                    Cell newCell = map.getIslandMap()[x - speed][y];
                                    if(newCell.getCountAnimalInCell(animal) < animal.getMaxPopulationOnCell()) {
                                        animal.setIsMoved(true);
                                        newCell.addAnimal(animal);
                                        cell.deleteAnimal(animal);
                                    }
                                }
                            }
                            if (direction == 3) { //вправо
                                if (y + speed < map.getWIDTH() - 1) {
                                    Cell newCell = map.getIslandMap()[x][y + speed];
                                    if(newCell.getCountAnimalInCell(animal) < animal.getMaxPopulationOnCell()) {
                                        newCell.addAnimal(animal);
                                        animal.setIsMoved(true);
                                        cell.deleteAnimal(animal);
                                    }
                                }
                            }
                            if (direction == 4) { //влево
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
//переписать- животные ходят только один раз за все время
//  case MOVE -> {
//                            lifeCycleExecutor.movingAnimals(animalList);
//                            lifeCycleExecutor.resetWalkStatus(animalList);
//                        }

