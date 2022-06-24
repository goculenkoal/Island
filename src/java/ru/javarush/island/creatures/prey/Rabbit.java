package ru.javarush.island.creatures.prey;

import ru.javarush.island.creatures.Population;
import ru.javarush.island.creatures.abstracts.Prey;

public class Rabbit extends Prey {
    public Rabbit() {
        super(Population.RABBIT.getMaxPopulationOnCell(),Population.RABBIT.getMoveSpeed(), 0.0,
                Population.RABBIT.getMoveForDead(), Population.RABBIT.getWeight());
        this.type = Population.RABBIT;
    }

    @Override
    public String toString() {
        return Population.RABBIT.getPicture();
    }
}
