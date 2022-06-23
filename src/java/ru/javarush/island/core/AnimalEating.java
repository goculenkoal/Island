package ru.javarush.island.core;

import ru.javarush.island.island.Cell;
import ru.javarush.island.creatures.Animal;

import java.util.List;

public class AnimalEating {

    public void eatAllAnimals(Cell cell) {
                List<Animal> listAnimal = cell.getAllAnimalInCell();
                for (Animal animal : listAnimal) {
                    animal.eat(cell);
                }

    }
}
