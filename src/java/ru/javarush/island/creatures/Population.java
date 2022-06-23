package ru.javarush.island.creatures;

import java.util.HashMap;
import java.util.Map;

public enum Population {

    WOLF(10,3, 8,50,3,"\uD83D\uDC3A" ),
    SHEEP(25, 2,15,70,4,"\uD83D\uDC11"),
    DEER(25, 2,50,300,4,"\uD83D\uDC11");
    //PLANT(200, 0, "\uD83C\uDF3E");



    private String picture;
    private int maxPopulationOnCell;
    private Map<String,Integer> optionMENU= new HashMap<>();
    private int maxSaturation;
    private double weight;
    private int moveSpeed;
    private int moveForDead;//Максимальное количество животных этого вида на одной клетке

    Population(int maxPopulationOnCell, int moveSpeed,int maxSaturation, double weight, int moveForDead, String picture) {
        this.maxPopulationOnCell = maxPopulationOnCell;
        this.moveSpeed = moveSpeed;
        this.picture = picture;
        this.maxSaturation = maxSaturation;
        this.weight = weight;
        this.moveForDead = moveForDead;
    }

    public String getPicture() {
        return picture;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public int getMaxPopulationOnCell() {
        return maxPopulationOnCell;
    }

    public int getMaxSaturation() {
        return maxSaturation;
    }

    public double getWeight() {
        return weight;
    }

    public int getMoveForDead() {
        return moveForDead;
    }
}
