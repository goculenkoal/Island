package ru.javarush.island;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    public static final Map<String, Integer> menuWolf = new HashMap<>();

    static {
        menuWolf.put("Sheep", 70);
        menuWolf.put("Deer",50);
    }

}
