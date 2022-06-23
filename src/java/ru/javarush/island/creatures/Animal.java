package ru.javarush.island.creatures;

import ru.javarush.island.island.Cell;
import ru.javarush.island.island.Island;

import java.util.Map;

/**
 * Абстрактный класс для всех животных: хищников и травоядных
 */
public abstract class Animal extends Island {

    public Population type;
    private final int maxPopulationOnCell;
    private final int moveSpeed;
    private double saturation;
    private int movesForDead;
    private double weight;
    private Map<String, Integer> huntMenu;// счетчик типа
    private boolean isMoved;


    /**
     * Конструктор для травоядных
     * @param maxPopulationOnCell - количество на клетке
     * @param moveSpeed - макс передвижение на количество клеток
     * @param saturation - насыщение
     * @param movesForDead - количество ходов до смерти
     * @param weight - вес
     */
    public Animal(int maxPopulationOnCell, int moveSpeed, double saturation, int movesForDead, double weight) {
        this.maxPopulationOnCell = maxPopulationOnCell;
        this.moveSpeed = moveSpeed;
        this.saturation = saturation;
        this.movesForDead = movesForDead;
        this.weight = weight;
    }

    /** Конструктор для хищников
     * @param huntMenu меню охоты
     */
    public Animal(int maxPopulationOnCell, int moveSpeed, double saturation, int movesForDead,double weight,
                  Map<String,Integer> huntMenu) {
        this(maxPopulationOnCell,moveSpeed, saturation,movesForDead,weight);
        this.huntMenu = huntMenu;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setIsMoved(boolean moved) {
        isMoved = moved;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public int getMaxPopulationOnCell() {
        return maxPopulationOnCell;
    }

    public Map<String, Integer> getHuntMenu() {
        return huntMenu;
    }

    public Population getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    public double getSaturation() {
        return saturation;
    }

    public int getMovesForDead() {
        return movesForDead;
    }

    public void setMovesForDead(int movesForDead) {
        this.movesForDead = movesForDead;
    }

    /**
     * @param cell - ячейка острова */
    public abstract void eat(Cell cell);
}


