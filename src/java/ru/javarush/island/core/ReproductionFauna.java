package ru.javarush.island.core;

import ru.javarush.island.island.Cell;
import ru.javarush.island.island.Island;
import ru.javarush.island.creatures.Animal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReproductionFauna {
    private Island map;

    public ReproductionFauna(Island map) {
        this.map = map;
    }


    public void multiply(Cell cell) { // Здесь размножаемся по четному числу особей

        List<Animal> tempAnimalList = new CopyOnWriteArrayList<>(List.copyOf(cell.getAllAnimalInCell())); // получаем список животных из ячейки


        for (Animal animal : tempAnimalList) {
            //System.out.println(animal.getPosition());
            if (getCountOfSpecies(animal, tempAnimalList) == animal.getMaxPopulationOnCell()) {
                continue;
            }

            if (getCountOfSpecies(animal, tempAnimalList) >= 2) {

                if ((getCountOfSpecies(animal, tempAnimalList) % 2 != 0)) {
                    tempAnimalList.remove(animal);
                    continue;
                }
            }

            if (cell.getCountAnimalInCell(animal) < animal.getMaxPopulationOnCell()) {
                Animal bornAnimal = map.fillObjectsOnCell(animal.getType());
                cell.addAnimal(bornAnimal);
                tempAnimalList.remove(animal);
            }
        }

    }


    private int getCountOfSpecies (Animal animal, List <Animal> animals) { // Подсчет числа особей

        Map<Object, Integer> collect = Stream.of(animals)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Object::toString, e -> 1, Integer::sum));
                    return collect.get(animal.toString());
    }
}

//приделать зависимость размножения от сытости - сытость больше половины - > размножаемся