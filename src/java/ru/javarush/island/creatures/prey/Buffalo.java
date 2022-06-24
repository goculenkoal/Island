package ru.javarush.island.creatures.prey;

import ru.javarush.island.creatures.Population;
import ru.javarush.island.creatures.abstracts.Prey;

public class Buffalo extends Prey {

    public Buffalo() {
        super(Population.BUFFALO.getMaxPopulationOnCell(),Population.BUFFALO.getMoveSpeed(), 0.0,
                Population.BUFFALO.getMoveForDead(), Population.BUFFALO.getWeight());
        this.type = Population.BUFFALO;
    }

    @Override
    public String toString() {
        return Population.BUFFALO.getPicture();
    }
}
