package ru.javarush.island.creatures.prey;

import ru.javarush.island.Population;
import ru.javarush.island.creatures.Prey;

public class Sheep extends Prey {

    public Sheep() {
        super(Population.SHEEP.getMaxPopulationOnCell(),Population.SHEEP.getMoveSpeed(), Population.SHEEP.getPicture(),
                Population.SHEEP.getMaxSaturation(), Population.SHEEP.getMoveForDead(), Population.SHEEP.getWeight());
        this.type = Population.SHEEP;
    }

    @Override
    public String toString() {
        //return "\uD83D\uDC11";
        return Population.SHEEP.getPicture();
    }


}
