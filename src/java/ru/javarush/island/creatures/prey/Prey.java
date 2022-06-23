package ru.javarush.island.creatures.prey;

import ru.javarush.island.island.Cell;
import ru.javarush.island.creatures.Animal;
import ru.javarush.island.creatures.flora.Plant;

import java.util.List;

public class Prey extends Animal {


    public Prey(int maxPopulation, int moveSpeed, String picture,double saturation, int movesForDead,double weight) {
        super(maxPopulation, moveSpeed, picture, saturation,movesForDead,weight);
    }

    @Override
    public void eat(Cell cell) {
        List<Plant> listPlant = cell.getAllPlantInCell();
        if (listPlant.size() > 0) {
            for(Plant plant : listPlant) {
                listPlant.remove(plant);
                break;
            }
        }

    }
}
