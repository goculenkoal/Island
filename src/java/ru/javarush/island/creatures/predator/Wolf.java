package ru.javarush.island.creatures.predator;

import ru.javarush.island.creatures.Population;
import ru.javarush.island.core.Settings;
import ru.javarush.island.creatures.abstracts.Predator;


public class Wolf extends Predator {

    public Wolf() {
        super(Population.WOLF.getMaxPopulationOnCell(),Population.WOLF.getMoveSpeed(),0.0,
                Population.WOLF.getMoveForDead(),Population.WOLF.getWeight(), Settings.menuWolf);
        this.type = Population.WOLF;
    }

    @Override
    public String toString() {
        return Population.WOLF.getPicture();
    }
}

