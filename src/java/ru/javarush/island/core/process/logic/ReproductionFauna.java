package ru.javarush.island.core.process.logic;

import ru.javarush.island.island.Cell;
import ru.javarush.island.island.Island;
import ru.javarush.island.creatures.abstracts.Animal;

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

    /**
     * Размножение по четному количеству животных, если общее количество нечетное, одно животное удаляется из списка, т.к не найдет пару для размножения
     * //приделать зависимость размножения от сытости - сытость больше половины - > размножаемся
     * @param cell на вход ячейка с животными
     */
    public void multiply(Cell cell) {

        List<Animal> tempAnimalList = new CopyOnWriteArrayList<>(List.copyOf(cell.getAllAnimalInCell())); // получаем список животных из ячейки


        for (Animal animal : tempAnimalList) {
            if (getCountOfAnimals(animal, tempAnimalList) == animal.getMaxPopulationOnCell()) {
                continue;
            }

            if (getCountOfAnimals(animal, tempAnimalList) >= 2) {

                if ((getCountOfAnimals(animal, tempAnimalList) % 2 != 0)) {
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

    /**
     *
     * @param animal - животное которое считаем
     * @param animals - список животных ячеек, в котором проводим подсчет
     * @return сумма животных определенного типа среди animal
     */
    private int getCountOfAnimals(Animal animal, List <Animal> animals) {

        Map<Object, Integer> collect = Stream.of(animals)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Object::toString, e -> 1, Integer::sum));
                    return collect.get(animal.toString());
    }
}

