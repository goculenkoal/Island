package ru.javarush.island;

import ru.javarush.island.creatures.Animal;
import ru.javarush.island.creatures.Predator;
import ru.javarush.island.creatures.Prey;

import java.util.List;

public class AnimalEating {
    Island map;

    public AnimalEating(Island island) {
        this.map = island;
    }

    public void eatAllAnimals() {
        for (int x = 0; x < map.getHEIGHT(); x++) {
            for (int y = 0; y < map.getWIDTH(); y++) {
                Cell cell = map.getIslandMap()[x][y];
                List<Animal> listAnimal = cell.getAllAnimalInCell();
                for(Animal animal : listAnimal) {
                    animal.eat(cell);
                    //System.out.println(animal + " поел");

                }
            }
        }
    }


}
