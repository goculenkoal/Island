package ru.javarush.island.creatures.prey;

import ru.javarush.island.creatures.Population;
import ru.javarush.island.creatures.abstracts.Prey;

public class Deer extends Prey {


    public Deer() {
        super(Population.DEER.getMaxPopulationOnCell(),Population.DEER.getMoveSpeed(), 0.0,
                Population.DEER.getMoveForDead(), Population.DEER.getWeight());
        this.type = Population.DEER;
    }


    @Override
    public String toString() {
        return Population.DEER.getPicture();
    }

}
