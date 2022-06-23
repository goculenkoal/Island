package ru.javarush.island.creatures;

import java.util.HashMap;
import java.util.Map;

public enum Population {

    WOLF    (30,3, 8,50,1,"\uD83D\uDC3A" ),
    ANACONDA(30,1, 3,15,1,"\uD83D\uDC0D"),
    SHEEP   (140, 3,15,70,2,"\uD83D\uDC11"),
    DEER    (20, 4,50,300,2,"\uD83E\uDD8C"),
    FOX     (30, 2,2,8,2,"\uD83E\uDD8A"),
    BEAR    (5, 2,80,500,4,"\uD83D\uDC3B"),
    EAGLE   (20, 3,1,6,2,"\uD83E\uDD85"),
    HORSE   (20, 4,60,400,2,"\uD83D\uDC0E"),
    RABBIT  (150, 2,0.45,400,1,"\uD83D\uDC30"),
    MOUSE   (500, 1,0.45,0.05,1,"\uD83D\uDC01"),
    GOAT    (140, 3,10,60,2,"\uD83D\uDC10"),
    APER    (50, 2,100,400,2,"\uD83D\uDC17"),
    BUFFALO (10, 3,100,700,3,"\uD83D\uDC03"),
    DUCK    (200, 3,0.15,1,1,"\uD83E\uDD86"),
    LARVA   (1000, 0,0,0.01,1,"\uD83D\uDC1B");

    private String picture;
    private int maxPopulationOnCell;
    private double maxSaturation;
    private double weight;
    private int moveSpeed;
    private int moveForDead;

    Population(int maxPopulationOnCell, int moveSpeed,double maxSaturation, double weight, int moveForDead, String picture) {
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

    public double getMaxSaturation() {
        return maxSaturation;
    }

    public double getWeight() {
        return weight;
    }

    public int getMoveForDead() {
        return moveForDead;
    }
}
