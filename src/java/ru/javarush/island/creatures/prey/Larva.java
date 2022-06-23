package ru.javarush.island.creatures.prey;

import ru.javarush.island.creatures.Population;

public class Larva extends Prey {
    public Larva() {
        super(Population.LARVA.getMaxPopulationOnCell(),Population.LARVA.getMoveSpeed(), 0.0,
                Population.LARVA.getMoveForDead(), Population.LARVA.getWeight());
        this.type = Population.LARVA;
    }

    @Override
    public String toString() {
        return Population.LARVA.getPicture();
    }

}
