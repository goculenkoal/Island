package ru.javarush.island.core.process.logic;

import ru.javarush.island.island.Cell;
import ru.javarush.island.creatures.abstracts.Animal;

import java.util.List;

public class AnimalEating {

    public void eatAllAnimals(Cell cell) {
                List<Animal> listAnimal = cell.getAllAnimalInCell();
                for (Animal animal : listAnimal) {
                    animal.eat(cell);
                }

    }
}
