package lesson4.Collections.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListLearn {
    public static void main(String[] args) {

        /*
        
        LinkedList - Один из подклассов класса List, в котором элементы хранят ссылки на следующий и предыдущий объект
        LinkedList - первый элемент называет head, last element - tail
        LinkedList предпочтительнее использовать когда предполагается множество операций вставки или удаления
        и мало операций get, т.к. для этого придется итерировать всю коллекцию до получения искомого

        Далее приведены примеры производительности при создании Linked и Array List, а также получения элемента из середины
        коллекции

         */

        //LinkedList tests :

        long startTime1 = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100_000_000; i++) {
            linkedList.add(i);
        }
        long finishTime1 = System.currentTimeMillis();
        System.out.println("Времени затрачено: " + (finishTime1 - startTime1) + " мс");

        // 90 - 110 мс для коллекции из 1 млн элементов
        // 1250 мс для коллекции из 10 млн элементов
        // 13905 мс для коллекции из 100 млн элементов


        long startTime2 = System.currentTimeMillis();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        for (int i = 0; i < 100_000_000; i++) {
            linkedList2.add(i);
        }
        System.out.println(linkedList2.get(500_000));
        long finishTime2 = System.currentTimeMillis();
        System.out.println("Времени затрачено: " + (finishTime2 - startTime2) + " мс");

        // 110 - 125 мс для коллекции из 1 млн элементов и получения 500_000 элемента
        // 1327 мс для коллекции из 10 млн элементов и получения 5_000_000 элемента
        // 14324 мс для коллекции из 100 млн элементов и получения 50_000_000 элемента


        /*
        ArrayList tests:
        */

        long startTime3 = System.currentTimeMillis();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            arrayList1.add(i);
        }
        long finishTime3 = System.currentTimeMillis();
        System.out.println("Времени затрачено: " + (finishTime3 - startTime3) + " мс");

        // 15 - 36 мс для коллекции из 1 млн элементов
        // 313 - 360 мс для коллекции из 10 млн элементов
        // 2454 - 2550 мс для коллекции из 100 млн элементов


        long startTime4 = System.currentTimeMillis();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int j = 0; j < 100_000_000; j++) {
            arrayList2.add(j);
        }
        System.out.println(arrayList2.get(0));
        long finishTime4 = System.currentTimeMillis();
        long res = finishTime4 - startTime4;

        System.out.println("Времени затрачено: " + res + " мс");


        // 15 - 63 мс для коллекции из 1 млн элементов и получения 500_000 элемента
        // 187 - 453 мс для коллекции из 10 млн элементов и получения 5_000_000 элемента
        // 2413 - 3218 мс для коллекции из 100 млн элементов и получения 50_000_000 элемента


        /*

        Таким образом разница между ArrayList и LinkedList при добавлении n элементов и взятия n/2 элемента коллекции
        3с и 14с (для 100 млн элементов) - разница в 11 секунд
        0.3с и 1.3с (для 10 млн элементов) - разница в 1 секунду
        0.03с и 0.11с (для 100 млн элементов) - разница в 0.08 секунд

        */


    }

}
