package ru.javarush.island.creatures.preditor;

import ru.javarush.island.creatures.Population;
import ru.javarush.island.core.Settings;


public class Wolf extends Predator {


    public Wolf() {
        super(Population.WOLF.getMaxPopulationOnCell(),Population.WOLF.getMoveSpeed(), Population.WOLF.getPicture(),
                Settings.menuWolf, 0.0,Population.WOLF.getMoveForDead(),Population.WOLF.getWeight());
        this.type = Population.WOLF;

    }

    public int getCount() {
        return id;
    }

    @Override
    public String toString() {

        return Population.WOLF.getPicture();
    }
}

