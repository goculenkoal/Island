package ru.javarush.island.creatures.predator;

import ru.javarush.island.core.Settings;
import ru.javarush.island.creatures.Population;

public class Eagle extends Predator{
    public Eagle() {
        super(Population.EAGLE.getMaxPopulationOnCell(),Population.EAGLE.getMoveSpeed(),0.0,
                Population.EAGLE.getMoveForDead(),Population.EAGLE.getWeight(), Settings.menuEagle);
        this.type = Population.EAGLE;
    }

    @Override
    public String toString() {
        return Population.EAGLE.getPicture();
    }
}
