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
        и мало операций get, т.к. для этого придется итерировать всю коллекцию до получения искомого.
        Спойлер: единственно выгодная операция для LinkedList - вставка в начало коллекции скоростью O(1).
        В остальных случаях - более производительным является всё же ArrayList

        Далее приведены примеры производительности при создании Linked и Array List, а также получения элемента из середины
        коллекции

*/

/*
        LinkedList tests :

        Добавление элементов в LinkedList (может быть до 15 секунд при 100 млн элементов, в зависимости от вашего железа)
*/

/*

        ArrayList<Long> testResults1 = new ArrayList<>();
        int a = 1_000_000;
        for (int j = 0; j < 10; j++) {
            long startTime1 = System.currentTimeMillis();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < a; i++) {
                linkedList.add(i);
            }
            long finishTime1 = System.currentTimeMillis();
            long res = finishTime1 - startTime1;
            testResults1.add(res);
            if (j == 3 || j == 6) {
                a = a * 10;
            }
            System.out.println("Времени затрачено: " + res + " мс " + "при добавлении " + a + " элементов");
            System.out.println();
        }
        System.out.println(testResults1);


        // 90 - 110 мс для коллекции из 1 млн элементов
        // 1250 мс для коллекции из 10 млн элементов
        // 13905 мс для коллекции из 100 млн элементов
             < -- тест для LinkedList добавление от 1 до 100 млн элементов
*/

/*
        ArrayList<Long> testResults2 = new ArrayList<>();
        int b = 1_000_000;
        for (int j = 0; j < 10; j++) {
            long startTime2 = System.currentTimeMillis();
            LinkedList<Integer> linkedList2 = new LinkedList<>();
            for (int i = 0; i < b; i++) {
                linkedList2.add(i);
            }
            System.err.println("Элемент из середины коллекции: " + linkedList2.get(b / 2));
            long finishTime2 = System.currentTimeMillis();
            long res = finishTime2 - startTime2;
            testResults2.add(res);
            if (j == 3 || j == 6) {
                b = b * 10;
            }
            System.out.println("Времени затрачено: " + res + " мс " + "при добавлении " + b + " элементов");
            System.out.println();
        }
        System.out.println(testResults2);

        // 110 - 125 мс для коллекции из 1 млн элементов и получения 500_000 элемента
        // 1327 мс для коллекции из 10 млн элементов и получения 5_000_000 элемента
        // 14324 мс для коллекции из 100 млн элементов и получения 50_000_000 элемента     < -- тест для LinkedList добавление от 1 до 100 млн элементов и взятие элемента из середины коллекции
*/


/*
        ArrayList tests:
*/

/*

        ArrayList<Long> testResults3 = new ArrayList<>();
        int a = 1_000_000;
        for (int j = 0; j < 10; j++) {
            long startTime3 = System.currentTimeMillis();
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                arrayList1.add(i);
            }
            long finishTime3 = System.currentTimeMillis();
            long res = finishTime3 - startTime3;
            testResults3.add(res);
            if (j == 3 || j == 6) {
                a = a * 10;
            }
            System.out.println("Времени затрачено: " + res + " мс " + "при добавлении " + a + " элементов");
            System.out.println();
        }
        System.out.println(testResults3);

        // 15 - 36 мс для коллекции из 1 млн элементов
        // 313 - 360 мс для коллекции из 10 млн элементов
        // 2454 - 2550 мс для коллекции из 100 млн элементов     < -- тест для ArrayList добавление от 1 до 100 млн элементов
*/

/*

        ArrayList<Long> testResults4 = new ArrayList<>();
        int b = 1_000_000;
        for (int j = 0; j < 10; j++) {
            long startTime4 = System.currentTimeMillis();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < b; i++) {
                arrayList2.add(i);
            }
            System.err.println("Элемент из середины коллекции: " + arrayList2.get(b / 2));
            long finishTime4 = System.currentTimeMillis();
            long res = finishTime4 - startTime4;
            testResults4.add(res);
            if (j == 3 || j == 6) {
                b = b * 10;
            }
            System.out.println("Времени затрачено: " + res + " мс " + "при добавлении " + b + " элементов");
            System.out.println();
        }
        System.out.println(testResults4);


        // 15 - 63 мс для коллекции из 1 млн элементов и получения 500_000 элемента
        // 187 - 453 мс для коллекции из 10 млн элементов и получения 5_000_000 элемента
        // 2413 - 3218 мс для коллекции из 100 млн элементов и получения 50_000_000 элемента
      < -- тест для ArrayList добавление от 1 до 100 млн элементов и взятие элемента из середины коллекции
*/

/*

        Таким образом разница между ArrayList и LinkedList при добавлении n элементов и взятия n/2 элемента коллекции
        3с и 14с (для 100 млн элементов) - разница в 11 секунд
        0.3с и 1.3с (для 10 млн элементов) - разница в 1 секунду
        0.03с и 0.11с (для 100 млн элементов) - разница в 0.08 секунд

*/



/*
      ADDITIONAL TESTS: | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
*/

/*

        ArrayList<Long> testResults5 = new ArrayList<>();
        int a = 1_000_000;
        for (int j = 0; j < 10; j++) {
            long startTime5 = System.currentTimeMillis();
            LinkedList<Integer> linkedList5 = new LinkedList<>();
            for (int i = 0; i < a; i++) {
                linkedList5.add(0,i);
            }
            long finishTime5 = System.currentTimeMillis();
            long res = finishTime5 - startTime5;
            testResults5.add(res);
            if (j == 3 || j == 6) {
                a = a * 10;
            }
            System.out.println("Времени затрачено: " + res + " мс " + "при добавлении " + a + " элементов");
            System.out.println();
        }
        System.out.println(testResults5);     <-- добавление от 1 до 100 млн элементов в начало LinkedList
*/

/*
        ArrayList<Long> testResults6 = new ArrayList<>();
        int a = 300_000;
        for (int j = 0; j < 10; j++) {
            long startTime6 = System.currentTimeMillis();
            ArrayList<Integer> arrayList6 = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                arrayList6.add(0,i);
            }
            long finishTime6 = System.currentTimeMillis();
            long res = finishTime6 - startTime6;
            testResults6.add(res);
            if (j == 3 || j == 6) {
                a = a * 10;
            }
            System.out.println("Времени затрачено: " + res + " мс " + "при добавлении " + a + " элементов");
            System.out.println();
        }
        System.out.println(testResults6);     <-- добавление 300_000 элементов в начало ArrayList. Есть множитель, но даже на 300_000 уходит в среднем 15 сек
        При 1 млн элементов неизвестно
*/

    }

}
