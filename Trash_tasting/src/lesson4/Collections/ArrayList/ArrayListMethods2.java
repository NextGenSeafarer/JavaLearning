package lesson4.Collections.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods2 {
    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Ilia");
        list1.add("Kirill");


        ArrayList<String> list2 = new ArrayList<>(list1);
        list2.add("Daria");

        list2.removeAll(list1); //list2.removeAll (Collection <?> c) - удал€ет все элементы коллекции 1 из коллекции 2

        list2.retainAll(list1); //list2.retainAll (Collection <?> c) - оставл€ет все элементы коллекции 1 в коллекции 2

        boolean isContains = list2.containsAll(list1); //если все элементы коллекции 2 содержат коллекцию 1

        List<String> list3 = list2.subList(0, 1);
        // создает sublist
        // если есть sublist - нельз€ измен€ть лист от которого он создан напр€мую, необходимо измен€ть sublist
        // элемент, добавленный в sublist - будет добавлен и в главный лист тоже

        String[] array = list1.toArray(new String[0]); //создание массива из листа
        //размерность массива = 0, чтобы java сама определила размерность, исход€ из list1.size

        List<Integer> intList = List.of(1, 2, 3); //быстрое создание листа с необходимыми данными
        // Ќ≈Ћ№«я ћќƒ»‘»÷»–ќ¬ј“№!!! Ќ≈Ћ№«я ƒќЅј¬Ћя“№ NULL


        List<String> list4 = List.copyOf(list1); //быстрое копирование листа с необходимыми данными
        // Ќ≈Ћ№«я ћќƒ»‘»÷»–ќ¬ј“№!!! Ќ≈Ћ№«я ƒќЅј¬Ћя“№ NULL

    }
}
