package ru.javarush.island.creatures.prey;

import ru.javarush.island.creatures.Population;
import ru.javarush.island.creatures.abstracts.Prey;

public class Goat extends Prey {
    public Goat() {
        super(Population.GOAT.getMaxPopulationOnCell(),Population.GOAT.getMoveSpeed(), 0.0,
                Population.GOAT.getMoveForDead(), Population.GOAT.getWeight());
        this.type = Population.GOAT;
    }


    @Override
    public String toString() {
        return Population.GOAT.getPicture();
    }

}
