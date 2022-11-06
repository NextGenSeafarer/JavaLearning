package lesson7.LambdaExpressions.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsInfo {

/*
    Stream - это последовательность элементов поддерживающих последовательные и параллельные операции над ними.
    Методы Stream НЕ МЕНЯЮТ САМУ КОЛЛЕКЦИЮ ИЛИ МАССИВ, ОТ КОТОРОЙ БЫЛ СОЗДАН STREAM!
    Существует 2 типа методов для Stream - intermediate или ещё их называют lazy (lazy - не будут выполнены без терминального метода) и terminal (eager)

    Method map - преобразование потока из одного типа в другой, например можно из ArrayList<String> сделать Set<Integer>
    при желании.

*/

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("OK let's go");
        list.add("Yes Sir");
        list.add("Is 300 $$$");
        list.add("Without future interruption lets..");
        System.out.println("original list: " + list); // original list

        //если бы я хотел записать длины всех слов в новую коллекцию, как бы я сделал:
        List<String> list2 = new ArrayList<>(); // создал новую коллекцию
        for (String s : list) {
            list2.add(String.valueOf(s.length()));
        }
        System.out.println("list2 formatted to length of Strings: " + list2);

        //теперь:
        List<Integer> list3 = list.stream().map(element -> element.length()).collect(Collectors.toList());
        System.out.println("list3 formatted to length of Strings: " + list3);

        // то же самое для Set

        Set<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(93);
        set.add(1);
        set.add(-44);
        System.out.println("Formatted set : " + set);

        Set<String> set2 = set.stream().map(setElement -> "My number is: " + setElement).collect(Collectors.toSet());
        System.out.println("Formatted set2 : " + set2);

        // то же самое для array

        int[] array = {2, 4, 5, 7};
        int[] array2 = Arrays.stream(array).map(arrayElement -> {
            if (arrayElement % 2 == 0) {
                arrayElement = arrayElement / 2;
            }
            return arrayElement;
        }).toArray();
        System.out.println("Array original  " + Arrays.toString(array));
        System.out.println("Array changed  " + Arrays.toString(array2));


    }


}
