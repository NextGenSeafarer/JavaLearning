package lesson6.LambdaExpressions.util.functions.Consumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachMethod {

    /*
        Полезная реализация функционального интерфейса Consumer - метод forEach для коллекций
    */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Say my name Billy");
        list.add("I'm Hizenberg");
        list.add("Yes Sir!");

        // раньше я бы сделал что - то типа:
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("<-------------------------------->");

        // или даже:
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("<-------------------------------->");

        //но зная интерфейс Consumer:

        list.forEach((string) -> System.out.println(string));
        //либо даже ещё короче: list.forEach(System.out::println);
        System.out.println("<-------------------------------->");

        // теперь работа с элементами коллекции может уместиться в пару строчек:

        //ВАЖНО! ПРЯМОЕ ИЗМЕНЕНИЕ КОЛЛЕКЦИИ невозможно! ! ! ! !

        ArrayList<String> list1 = new ArrayList<>();

        Consumer<String> stringHizenbergToBeReplacedWithAnySymbol = string -> {
            list1.add(string.replaceAll("Hizenberg", "%".repeat("Hizenberg".length())));
        }; // создаю лямбда выражение для Consumer

        list.forEach(stringHizenbergToBeReplacedWithAnySymbol); // заменяю Hizenberg на любой символ во всей коллекции

        System.out.println(list);
        System.out.println("<-------------------------------->");
        System.out.println(list1);
        System.out.println("<-------------------------------->\n");


/*
        ---------------------------------------------------------------------------------------------------------------
        Работа с Integer
*/
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(1);
        integerLinkedList.add(2);
        integerLinkedList.add(3);
        integerLinkedList.add(4);
        integerLinkedList.add(5);

        System.out.println(integerLinkedList);
        System.out.println("<-------------------------------->");

        integerLinkedList.forEach(integer -> {
            System.out.println(integer);
            integer*=2;
            System.out.println(integer);
        });
        System.out.println(integerLinkedList);




    }


}

