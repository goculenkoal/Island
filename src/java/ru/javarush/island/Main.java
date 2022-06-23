package ru.javarush.island;

import ru.javarush.island.core.SimulateLifeActions;
import ru.javarush.island.island.Island;

public class Main {
    public static void main(String[] args) {
        Island map = new Island();

//        SimulateLifeActions simulateLifeActions = new SimulateLifeActions();
//        simulateLifeActions.initialiseIsland();
//        simulateLifeActions.








        //new LifeController().startGame();
//        Map<String, Integer> menu1 = new HashMap<>();
//        menu1.put("Sheep", 70);
//        menu1.put("Deer", 50);
//
//
//        List<Animal> list = new ArrayList<>();
//
//        list.add(new Deer());
//        list.add(new Deer());
//        list.add(new Sheep());
//        list.add(new Sheep());
//        list.add(new Sheep());
//        list.add(new Wolf());
//        System.out.println(list);
//
//        List<String> listOfHunts = getListOfHunts(menu1);
//        System.out.println(listOfHunts + " ooops");

//
//
//
//
//        int eatChance = ThreadLocalRandom.current().nextInt(0, 100);
//        System.out.println(eatChance);
//        List<String> listOfHunts = menu1.entrySet().stream()
//                .filter(entry ->  entry.getValue() < eatChance)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//        System.out.println(listOfHunts + " лист жертв");

//        String animalToEat;
//        int listOfHuntsId;
//        if(!listOfHunts.isEmpty()) {
//            listOfHuntsId = ThreadLocalRandom.current().nextInt(0, listOfHunts.size());
//            animalToEat = listOfHunts.get(listOfHuntsId);
//            System.out.println("кушаем " + animalToEat);
////
//
//
//            for(Animal animal : list) {
//                if(animal.getClass().getSimpleName().equals(animalToEat)) {
//                    list.remove(animal);
//                    break;
//                }
//            }
//        }
//        System.out.println("новый список " + list);
////
//
//        for(Animal animal : list) {
//            animal.eatTest();
//        }
//
//    }
//    public static List<String> getListOfHunts(Map<String, Integer> menuOption) {
//        int eatChance = ThreadLocalRandom.current().nextInt(79, 100);
//        System.out.println(eatChance);
//        List<String> listOfHunts = menuOption.entrySet().stream()
//                .filter(entry ->  entry.getValue() < eatChance)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//        return listOfHunts;
//    }
//


        //Plant plant = new Plant();
//        System.out.println("Start to generate Island");
//        Island island = new Island();
//        island.builtIsland();
//        island.fillupd();
//        island.islandViewer();
//        MovementFauna movement = new MovementFauna(island);
//        ReproductionFauna reproductionFauna = new ReproductionFauna(island);
//        AnimalEating predatorEating = new AnimalEating(island);
//        // movement.doMove();
//        //reproductionFauna.multiply();
//        //island.printIsland();
//        System.out.println();
//        island.islandViewer();
//        predatorEating.eatAllAnimals();
//        System.out.println();
//        island.islandViewer();

//
//        System.out.println(plant.getMaxOnCell());
//        System.out.println(plant);
//        island.getIslandMap();
//        System.out.println(Arrays.deepToString(island.getIslandMap()));
//        Wolf wolf = new Wolf();
//        System.out.println(wolf.getClass().getSimpleName());


    }
}

////
//        System.out.println();
//        island.islandViewer();
//        System.out.println();
//           island.testStreamViewer();
//        List<Animal> list = new ArrayList<>();
//        list.add(new Wolf());
//        list.add(new Wolf());
//        list.add(new Wolf());
//        list.add(new Wolf());
//        list.add(new Wolf());
//        list.add(new Wolf());
//
//        list.add(new Sheep());
//        list.add(new Sheep());
//        list.add(new Sheep());
//
//        for(Animal animal : list) {
//            animal.getMaxPopulationOnCell();
//
//        }
  //  }
//}

//сделать фиксированный размер ячейки через стат переменную int static maxOnCage = 60; к примеру - готово
// избавиться от Population
//сделать размножение
