package ru.javarush.island.creatures.abstracts;

import ru.javarush.island.island.Cell;
import ru.javarush.island.creatures.abstracts.Animal;
import ru.javarush.island.creatures.flora.Plant;
import java.util.List;

/**
 * to do - доработать логику для баланса
 */
public class Prey extends Animal {

    public Prey(int maxPopulation, int moveSpeed,double saturation, int movesForDead,double weight) {
        super(maxPopulation, moveSpeed,saturation, movesForDead, weight);
    }

    @Override
    public void eat(Cell cell) {
        List<Plant> listPlant = cell.getAllPlantInCell();
        if (!listPlant.isEmpty()) {
            for(Plant plant : listPlant) {
                listPlant.remove(plant);
                this.setSaturation(this.type.getMaxSaturation());
                break;
            }
        } else {
            this.setSaturation(0.0);
            this.setMovesForDead(this.getMovesForDead()-1);
        }
        if (this.getMovesForDead() <= 0) {
            cell.deleteAnimal(this);
        }
    }
}
