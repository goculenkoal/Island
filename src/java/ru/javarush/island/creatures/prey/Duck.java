package ru.javarush.island.creatures.prey;

import ru.javarush.island.creatures.Population;

public class Duck extends Prey {

    public Duck() {
        super(Population.DUCK.getMaxPopulationOnCell(),Population.DUCK.getMoveSpeed(), 0.0,
                Population.DUCK.getMoveForDead(), Population.DUCK.getWeight());
        this.type = Population.DUCK;
    }

    @Override
    public String toString() {
        return Population.DUCK.getPicture();
    }
}
