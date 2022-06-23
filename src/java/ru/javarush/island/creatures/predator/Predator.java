package ru.javarush.island.creatures.predator;

import ru.javarush.island.island.Cell;
import ru.javarush.island.creatures.Animal;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public abstract class Predator extends Animal {
    public Predator(int maxPopulation, int moveSpeed, double saturation, int moveToDeath, double weight,
                    Map<String,Integer> menu) {
        super(maxPopulation, moveSpeed, saturation, moveToDeath, weight, menu);
    }

    /**
     * Метод "покушать" для всех хищников //надо доделать логику насыщения в зависимости от веса съеденного животного
     * @param cell - ячейка острова
     */
    @Override
    public void eat(Cell cell) {
        if (this.getSaturation() < this.getType().getMaxSaturation()) {

            int listOfHuntsId;
            String animalToEat;
            List<String> listOfHunts = getListOfHunts(getHuntMenu());

            if (!listOfHunts.isEmpty()) {
                listOfHuntsId = ThreadLocalRandom.current().nextInt(0, listOfHunts.size());
                animalToEat = listOfHunts.get(listOfHuntsId);

                for (Animal searchPrey : cell.getAllAnimalInCell()) {
                    if (searchPrey.getClass().getSimpleName().equals(animalToEat)) {
                        this.setMovesForDead(this.type.getMoveForDead());
                        this.setSaturation(this.getSaturation() + 1);
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

    /**
     * Кидается кубик, чтобы определить шанс охоты.
     * @param menuOption карта меню
     * @return возвращает список кандидатов на охоту в зависимости от процента удачной охоты
     */
    private List<String> getListOfHunts(Map<String, Integer> menuOption) {
        int eatChance = ThreadLocalRandom.current().nextInt(0, 100);

        return menuOption.entrySet().stream()
                .filter(entry ->  entry.getValue() < eatChance)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}