package lesson4.Collections.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListLearn {
    public static void main(String[] args) {

        /*
        LinkedList - это один из наследников класса List, в котором элементы хранятся с данными на предыдущий и следующий
        объект в листе.
        Первый элемент LinkedList - head, last element - tail.
        LinkedList прекрасно подойдет, если необходимо делать множество операций вставки и удаления
        Метод get - крайне трудозатратный, т.к. чтобы, получить любой элемент коллекции необходимо пройти по всем предыдущим
        элементам начиная с головы или хвоста коллекции.
        Однако при добавлении или удалении элемента будут меняться просто ссылки на объект, которые не влияют на остальные
        элементы коллекции, потому это будет выполнено мгновенно.
         */

        long startTime1 = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1; i++) {
            linkedList.add(i);
        }
        long finishTime1 = System.currentTimeMillis();
        System.out.println("Затраченное время: " + (finishTime1 - startTime1) + " мс");

        // 90 - 110 миллисекунд на добавление 1 миллиона элементов в LinkedList  !
        // 1250 миллисекунд на добавление 10 миллионов элементов в LinkedList    !!!!
        // 13905 миллисекунд на добавление 100 миллионов элементов в LinkedList  !!!!!!!!!!!!!!!!!


        long startTime2 = System.currentTimeMillis();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        for (int i = 0; i < 1_000_000; i++) {
            linkedList2.add(i);
        }
        System.out.println(linkedList2.get(500_000));
        long finishTime2 = System.currentTimeMillis();
        System.out.println("Затраченное время: " + (finishTime2 - startTime2) + " мс");

        // 110 - 125 миллисекунд на добавление 1 миллиона элементов в LinkedList и получения 500_000 элемента
        // 1327 миллисекунд на добавление 10 миллионов элементов в LinkedList и получение 5_000_000 элемента
        // 14324 миллисекунд на добавление 100 миллионов элементов в LinkedList и получение 50_000_000 элемента


        /*
        Разница в пол секунды на 10 миллионах и такая же на 100 миллионах. Далее проверим ArrayList на те же операции
        */

        long startTime3 = System.currentTimeMillis();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            arrayList1.add(i);
        }
        long finishTime3 = System.currentTimeMillis();
        System.out.println("Затраченное время: " + (finishTime3 - startTime3) + " мс");

        // 15 - 36 миллисекунд на добавление 1 миллиона элементов в ArrayList
        // 313 - 360 миллисекунд на добавление 10 миллионов элементов в ArrayList
        // 2454 - 2550 миллисекунд на добавление 100 миллионов элементов в ArrayList


        long startTime4 = System.currentTimeMillis();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int j = 0; j < 1; j++) {
            arrayList2.add(j);
        }
        System.out.println(arrayList2.get(0));
        long finishTime4 = System.currentTimeMillis();
        long res = finishTime4 - startTime4;

        System.out.println("Затраченное время: " + res + " мс");


        // 15 - 63 миллисекунд на добавление 1 миллиона элементов в ArrayList и получение 500_000 элемента
        // 187 - 453 миллисекунд на добавление 10 миллионов элементов в ArrayList и получение 5_000_000 элемента
        // 2413 - 3218 миллисекунд на добавление 100 миллионов элементов в ArrayList и получение 50_000_000 элемента


        /*

        Производительность ArrayList в сравнении с LinkedList - 3 с против 14 с (11 секунд) на 100 млн элементов
        0.3 с против 1.3 с (1 секунда) на 10 млн элементов и 0.03 с и 0.11 с (0.08 секунд) на 1 млн элементов соответственно

        */


    }

}
