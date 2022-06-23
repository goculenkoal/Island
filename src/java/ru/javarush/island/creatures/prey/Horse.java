package ru.javarush.island.creatures.prey;

import ru.javarush.island.creatures.Population;

public class Horse extends Prey {
    public Horse() {
        super(Population.HORSE.getMaxPopulationOnCell(),Population.HORSE.getMoveSpeed(), 0.0,
                Population.HORSE.getMoveForDead(), Population.HORSE.getWeight());
        this.type = Population.HORSE;
    }


    @Override
    public String toString() {
        return Population.HORSE.getPicture();
    }

}

