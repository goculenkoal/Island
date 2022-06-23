package ru.javarush.island.creatures;

import ru.javarush.island.island.Cell;
import ru.javarush.island.island.Island;

import java.util.Map;

public abstract class Animal extends Island {

    public Population type;
    protected int id;
    // Скорость перемещения, не более чем, клеток за ход
    private double saturation; //Сытость
    private int movesForDead; //Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private Map<String, Integer> huntMenu;// счетчик типа



    private double weight;
    private final int maxPopulationOnCell; // Максимальное количество животных этого вида на одной клетке
    private int moveSpeed;
    private boolean isMoved;
    String picture;



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


    public Animal(int maxPopulation, int moveSpeed, String picture,double saturation,int movesForDead,double weight) { //конструктор с Меню
        this.maxPopulationOnCell = maxPopulation;
        this.moveSpeed = moveSpeed;
        this.picture = picture;
        this.saturation = saturation;
        this.movesForDead = movesForDead;
        this.weight = weight;
    }

    /**
     *
     * @param maxPopulation количество на клетке
     * @param moveSpeed макс передвижение на
     * @param picture эмоджи
     * @param huntMenu меню охоты
     * @param saturation насыщение
     * @param movesForDead количество тиков до смерти
     * @param weight вес
     */
    public Animal(int maxPopulation, int moveSpeed, String picture, Map<String,Integer> huntMenu, double saturation,
                  int movesForDead, double weight) {
        this(maxPopulation,moveSpeed,picture,saturation,movesForDead,weight);
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

    public abstract void eat(Cell cell);
}


