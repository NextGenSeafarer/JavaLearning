package lesson4.Collections.Queue;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class priorityQueue {

    /*
    Priority Queue - коллекция, которая учитывает приоритет элемента, т.е. сортирует элементы по возрастанию
    в натуральном ордере, если это возможно (допустим для Integer), при этом на экран сама коллекция выводится не в
    НАТУРАЛЬНОМ ОРДЕРЕ - ПРИМЕР НИЖЕ!!!
    Максимальны приоритет у наименьшего элемента, минимальный - у наибольшего элемента
    Пример в классе priorityQueueExampleWithGeneric
    */
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(1);
        priorityQueue.add(10);
        priorityQueue.add(2);
        priorityQueue.add(14);
        priorityQueue.add(9);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());
        priorityQueue.remove();
        System.out.println(priorityQueue);
        priorityQueue.remove();
        System.out.println(priorityQueue);
        priorityQueue.remove();
        System.out.println(priorityQueue);
        priorityQueue.remove();
        System.out.println(priorityQueue);


    }
}
