package ru.javarush.island.creatures.prey;

import ru.javarush.island.creatures.Population;

public class Deer extends Prey {


    public Deer() {
        super(Population.DEER.getMaxPopulationOnCell(),Population.DEER.getMoveSpeed(), Population.DEER.getPicture(),
                Population.DEER.getMaxSaturation(), Population.DEER.getMoveForDead(), Population.DEER.getWeight());
        this.type = Population.DEER;
    }


    @Override
    public String toString() {
        //return "\uD83D\uDC11";
        return "\uD83E\uDD8C";
    }

}
