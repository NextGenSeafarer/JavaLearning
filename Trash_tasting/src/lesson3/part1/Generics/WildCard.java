package lesson3.part1.Generics;

import java.util.ArrayList;
import java.util.List;

/*
    Wildcard <?> необходим для того, чтобы использовать в методах любой тип переданных данных,
    а также ограничивать типы данных, которые могут быть переданы + сохранение type safe идеи как для всех
    generics.

*/


public class WildCard {
    public static void main(String[] args) {

        ArrayList<?> list1 = new ArrayList<Integer>();
//        list1.add(5);  не будет работать, так как для wildcard ArrayList - добавление любого типа данных, когда
//                       Точно не известно какого типа Array - не безопасно. Изменение объекта с wildcard - запрещено.

//  ------------------------------------------------------------------------------------------------------------------

//      в метод showListElements можно передать любой тип данных

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        showListElements(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        showListElements(list3);

        ArrayList<Number> list4 = new ArrayList<>();
        list4.add(3.14);
        list4.add(3.15);
        list4.add(3.16);
        showListElements(list4);

//  ------------------------------------------------------------------------------------------------------------------
//    Bounded Wild Card
//        Ограничение по типу передаваемых данных (т.е. в метод sumElement можно передать только subclasses Number)

        ArrayList<Double> list5 = new ArrayList<>();
        list5.add(1.11);
        list5.add(1.12);
        list5.add(1.13);
        System.out.println(sumElements(list5));
//      System.out.println(sumElements(list2)); - уже не подходит, так как list2 - не подтипа Number




    }
    static void showListElements(List<?> list) {
        System.out.println("My Array elements: " + list);
    }

    public static double sumElements(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }


}
