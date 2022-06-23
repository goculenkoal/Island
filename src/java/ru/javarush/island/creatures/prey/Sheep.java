package ru.javarush.island.creatures.prey;

import ru.javarush.island.creatures.Population;

public class Sheep extends Prey {

    public Sheep() {
        super(Population.SHEEP.getMaxPopulationOnCell(),Population.SHEEP.getMoveSpeed(),0.0,
                Population.SHEEP.getMoveForDead(), Population.SHEEP.getWeight());
        this.type = Population.SHEEP;
    }

    @Override
    public String toString() {
        return Population.SHEEP.getPicture();
    }
}
