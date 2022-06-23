package ru.javarush.island.island;

import ru.javarush.island.creatures.Animal;
import ru.javarush.island.creatures.Population;
import ru.javarush.island.creatures.preditor.Wolf;
import ru.javarush.island.creatures.prey.Deer;
import ru.javarush.island.creatures.prey.Sheep;
import ru.javarush.island.island.Cell;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Island extends Cell {


    /**
     * Размер острова
     */
     private final int WIDTH = 3; //10
     private final int HEIGHT = 3; // 5


    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * массив ячеек Cell острова
     */
    Cell[][] islandMap;

    /**
     * инициализация размера острова по умолчанию
     */
    public Island() {
        super();
        islandMap = new Cell[HEIGHT][WIDTH];
    }

    public Island(int x, int y) {
        super(x,y);
        islandMap = new Cell[x][y];
    }
    /** Возврат ячейки по координатам*/
    public Cell[][] getIslandMap() {
        return islandMap;
    }

    /**
     * создание острова с null объектами
     */
    public void builtIsland() {
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                islandMap[x][y] = new Cell(x, y);
            }
        }
    }


    public void setIslandMap(Cell[][] islandMap) {
        this.islandMap = islandMap;
    }

    /**
     * вывод острова на экран
     */
    public void printIsland() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(islandMap[y][x]);
            }
            System.out.println();
        }
    }


    public void fillupd() {
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                Cell cell = islandMap[x][y];
                cell.generatePlants();
                for (Population population : Population.values()) {
                    //if (!population.name().equals("PLANT")) { //Убираем планты
                    for (int i = 0; i < new Random().nextInt(population.getMaxPopulationOnCell() + 1); i++) {
                        islandMap[x][y].getAllAnimalInCell().add(fillObjectsOnCell(population));
                    }
                   // }
                }
            }
        }
    }



    public Animal fillObjectsOnCell(Population type) { //Фабрика для заполнения острова объектами //вынести в отдельный
        // класс, чтобы получать доступ из других классов

        return switch (type) {

            case WOLF -> new Wolf();
            case SHEEP -> new Sheep();
            case DEER -> new Deer();

        };
    }

    public void islandViewer() {

        for (Cell[] cells : islandMap) {
            for (Cell cell : cells) {

                Map<Object, Integer> collect = Stream.of(cell.getAllAnimalInCell(),cell.getAllPlantInCell())
                        .flatMap(Collection::stream)
                        .collect(Collectors.toMap(Object::toString, e -> 1, Integer::sum));

                System.out.print(collect);
            }
            System.out.println();
        }
    }


    public void testStreamViewer() {
        Arrays.stream(islandMap).map(Arrays::toString).forEach(System.out::println);
    }

    public void fill(Population population) {
        for (int coordY = 0; coordY < HEIGHT; coordY++) {
            for (int coordX = 0; coordX < WIDTH; coordX++) {
                Random rand = new Random();
                for (int i = 0; i < rand.nextInt(population.getMaxPopulationOnCell()); i++) {
                    Wolf wolf = new Wolf();
                    islandMap[coordY][coordX].addAnimal(wolf);
                }
            }
        }
    }

}