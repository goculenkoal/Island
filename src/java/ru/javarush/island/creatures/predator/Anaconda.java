package ru.javarush.island.creatures.predator;

import ru.javarush.island.core.Settings;
import ru.javarush.island.creatures.Population;

public class Anaconda extends Predator {
    public Anaconda() {
        super(Population.ANACONDA.getMaxPopulationOnCell(),Population.ANACONDA.getMoveSpeed(),0.0,
                Population.ANACONDA.getMoveForDead(),Population.ANACONDA.getWeight(), Settings.menuAnaconda);
        this.type = Population.ANACONDA;
    }

    @Override
    public String toString() {
        return Population.ANACONDA.getPicture();
    }
}

