package ru.javarush.island.creatures.flora;

public class Plant {
    private final int maxOnCell;

    public Plant() {
        this.maxOnCell = 200;
    }

    public int getMaxOnCell() {
        return maxOnCell;
    }

    @Override
    public String toString() {
        return "\uD83C\uDF3E";
    }
}
