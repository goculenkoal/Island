package ru.javarush.island;
import ru.javarush.island.creatures.preditor.Wolf;

public class Island {
    /** * Размер острова*/
    static final int WIDTH = 5;
    static final int HEIGHT = 5;

    /** * массив ячеек Cell острова*/
    Cell[][] islandMap;

    /** инициализация размера острова по умолчанию */
    public Island() {
        islandMap = new Cell[WIDTH][HEIGHT];
    }

    /** *создание острова с null объектами */
    public void builtIsland() {
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                islandMap[x][y] = new Cell(x,y);
            }
        }
    }

    /**
     * вывод острова на экран */
    public void printIsland() {
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                System.out.print(islandMap[x][y]);
            }
            System.out.println();
        }
    }

    public void createAnimal() {
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                Wolf wolf = new Wolf();
                islandMap[x][y].addAnimal(wolf);
            }
        }
    }


}
