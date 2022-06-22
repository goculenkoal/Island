package ru.javarush.island.creatures;

import ru.javarush.island.Cell;
import ru.javarush.island.creatures.preditor.Wolf;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public abstract class Predator extends Animal {
    public Predator(int maxPopulation, int moveSpeed, String picture, Map<String,Integer> menu, double saturation,
                    int moveToDeath, double weight) {
        super(maxPopulation, moveSpeed,picture, menu, saturation, moveToDeath, weight);
    }

    @Override
    public void eat(Cell cell) {
        if (this.getSaturation() < this.getType().getMaxSaturation()) {

            int listOfHuntsId;
            String animalToEat;
            List<String> listOfHunts = getListOfHunts(getHuntMenu()); // получаем список всех на кого можем охотиться

            if (!listOfHunts.isEmpty()) {
                listOfHuntsId = ThreadLocalRandom.current().nextInt(0, listOfHunts.size());
                animalToEat = listOfHunts.get(listOfHuntsId);

                for (Animal searchPrey : cell.getAllAnimalInCell()) { //ищем жертву на клетке
                    if (searchPrey.getClass().getSimpleName().equals(animalToEat)) {
                        this.setMovesForDead(this.type.getMoveForDead());
                        this.setSaturation(this.getSaturation() + searchPrey.getWeight());
                        cell.deleteAnimal(searchPrey);
                        break;
                    }
                }

            } else {
                this.setSaturation(0);
                this.setMovesForDead(this.getMovesForDead()-1);
            }
        }

        if (this.getMovesForDead() <= 0) {
            cell.deleteAnimal(this);
        }
    }

    private List<String> getListOfHunts(Map<String, Integer> menuOption) {
        int eatChance = ThreadLocalRandom.current().nextInt(0, 100);
        //System.out.println(eatChance);
        List<String> listOfHunts = menuOption.entrySet().stream()
                .filter(entry ->  entry.getValue() < eatChance)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return listOfHunts;
    }


    /**
     * тестовая еда - удалить
     */
    @Override
    public void eatTest() {
        System.out.println("Хищник поел");
    }
}