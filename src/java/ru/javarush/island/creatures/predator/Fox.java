package ru.javarush.island.creatures.predator;

import ru.javarush.island.core.Settings;
import ru.javarush.island.creatures.Population;

public class Fox extends Predator{
    public Fox() {
        super(Population.FOX.getMaxPopulationOnCell(),Population.FOX.getMoveSpeed(),0.0,
              Population.FOX.getMoveForDead(),Population.FOX.getWeight(), Settings.menuFox);
        this.type = Population.FOX;
    }

    @Override
    public String toString() {
        return Population.FOX.getPicture();
    }
}
