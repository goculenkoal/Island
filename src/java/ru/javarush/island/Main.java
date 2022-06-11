package ru.javarush.island;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start to generate Island");
        Island island = new Island();
        island.builtIsland();
        island.createAnimal();
        island.printIsland();
    }
}
