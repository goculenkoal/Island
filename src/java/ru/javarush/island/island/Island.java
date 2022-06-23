package ru.javarush.island.island;

import ru.javarush.island.core.Settings;
import ru.javarush.island.creatures.Animal;
import ru.javarush.island.creatures.Population;
import ru.javarush.island.creatures.predator.*;
import ru.javarush.island.creatures.prey.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Island extends Cell {


    /**
     * Размер острова
     */
     private final int width = Settings.WIDTH; //10
     private final int height = Settings.HEIGHT; // 5


    public int getWIDTH() {
        return width;
    }

    public int getHEIGHT() {
        return height;
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
        islandMap = new Cell[height][width];
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
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                islandMap[x][y] = new Cell(x, y);
            }
        }
    }

    public void fillupd() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                Cell cell = islandMap[x][y];
                cell.generatePlants();
                for (Population population : Population.values()) {
                    for (int i = 0; i < new Random().nextInt(population.getMaxPopulationOnCell() + 1); i++) {
                        islandMap[x][y].getAllAnimalInCell().add(fillObjectsOnCell(population));
                    }
                }
            }
        }
    }

    /**
     * //Фабрика для заполнения острова объектами //вынести в отдельный
     *         // класс, чтобы получать доступ из других классов
     *         //to do - написать метод для рандомного пика из фабрики - ?
     */
    public Animal fillObjectsOnCell(Population type) {

        return switch (type) {

            case WOLF -> new Wolf();
            case SHEEP -> new Sheep();
            case DEER -> new Deer();
            case ANACONDA -> new Anaconda();
            case FOX -> new Fox();
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case HORSE -> new Horse();
            case RABBIT -> new Rabbit();
            case MOUSE -> new Mouse();
            case GOAT -> new Goat();
            case APER -> new Aper();
            case BUFFALO -> new Buffalo();
            case DUCK -> new Duck();
            case LARVA -> new Larva();
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
}