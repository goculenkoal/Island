package ru.javarush.island.creatures.prey;

import ru.javarush.island.creatures.Population;
import ru.javarush.island.creatures.abstracts.Prey;

public class Aper extends Prey {
    public Aper() {
        super(Population.APER.getMaxPopulationOnCell(),Population.APER.getMoveSpeed(), 0.0,
                Population.APER.getMoveForDead(), Population.APER.getWeight());
        this.type = Population.APER;
    }

    @Override
    public String toString() {
        return Population.APER.getPicture();
    }
}
