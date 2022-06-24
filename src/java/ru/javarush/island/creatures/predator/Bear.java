package ru.javarush.island.creatures.predator;

import ru.javarush.island.core.Settings;
import ru.javarush.island.creatures.Population;
import ru.javarush.island.creatures.abstracts.Predator;

public class Bear extends Predator {
    public Bear() {
        super(Population.BEAR.getMaxPopulationOnCell(),Population.BEAR.getMoveSpeed(),0.0,
                Population.BEAR.getMoveForDead(),Population.BEAR.getWeight(), Settings.menuBear);
        this.type = Population.ANACONDA;
    }

    @Override
    public String toString() {
        return Population.BEAR.getPicture();
    }
}
