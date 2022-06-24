package ru.javarush.island.creatures.prey;

import ru.javarush.island.creatures.Population;
import ru.javarush.island.creatures.abstracts.Prey;

public class Mouse extends Prey {
    public Mouse() {
        super(Population.MOUSE.getMaxPopulationOnCell(),Population.MOUSE.getMoveSpeed(), 0.0,
                Population.MOUSE.getMoveForDead(), Population.MOUSE.getWeight());
        this.type = Population.MOUSE;
    }

    @Override
    public String toString() {
        return Population.MOUSE.getPicture();
    }
}
