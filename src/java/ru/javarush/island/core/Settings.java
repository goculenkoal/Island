package ru.javarush.island.core;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    public static final int DOWN = 1;
    public static final int UP = 2;
    public static final int RIGHT = 3;
    public static final int LEFT = 4;

    public static final int WIDTH = 100;
    public static final int HEIGHT = 20;

    public static final Map<String, Integer> menuWolf = new HashMap<>();
    public static final Map<String, Integer> menuAnaconda = new HashMap<>();
    public static final Map<String, Integer> menuFox = new HashMap<>();
    public static final Map<String, Integer> menuBear = new HashMap<>();
    public static final Map<String, Integer> menuEagle = new HashMap<>();

    static {
        menuWolf.put("Sheep", 70);
        menuWolf.put("Deer",50);
        menuWolf.put("Horse",10);
        menuWolf.put("Rabbit",60);
        menuWolf.put("Mouse",80);
        menuWolf.put("Goat",80);
        menuWolf.put("Aper",15);
        menuWolf.put("Buffalo",10);
        menuWolf.put("Duck",45);

        menuAnaconda.put("Fox", 15);
        menuAnaconda.put("Rabbit",20);
        menuAnaconda.put("Mouse",40);
        menuAnaconda.put("Duck",10);

        menuFox.put("Rabbit",70);
        menuFox.put("Mouse", 90);
        menuFox.put("Duck",60);
        menuFox.put("Larva",40);

        menuBear.put("Anaconda",80);
        menuBear.put("Horse",40);
        menuBear.put("Deer",80);
        menuBear.put("Rabbit",80);
        menuBear.put("Mouse",90);
        menuBear.put("Goat",70);
        menuBear.put("Sheep",70);
        menuBear.put("Aper",50);
        menuBear.put("Buffalo",20);
        menuBear.put("Duck",10);

        menuEagle.put("Fox", 10);
        menuEagle.put("Rabbit", 90);
        menuEagle.put("Mouse", 90);
        menuEagle.put("Duck", 80);
    }
}
