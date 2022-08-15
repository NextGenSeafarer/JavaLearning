package lesson4.Collections.HashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapEx {

    /*
           LinkedHashMap является наследником HashMap и
           отличается от HashMap тем, что порядок добавления элементов будет сохраняться при его создании
           Скорость методов - немногим ниже чем у HashMap


    */
    public static void main(String[] args) {

        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
                                        // accessOrder - при значении true - будет менять порядок элементов LinkedHashMap по их использованию
                                        // под использованием можно понимать методы put, get, etc.
        linkedHashMap.put(1,"OK");
        linkedHashMap.put(12,"KO");
        linkedHashMap.put(2,"KOKOKO");
        linkedHashMap.put(0,"okOkOk");
        System.out.println(linkedHashMap); // - выведен лист так, как он был добавлен

        linkedHashMap.get(0);
        linkedHashMap.get(2);
        linkedHashMap.get(12);
        linkedHashMap.get(1);

        System.out.println(linkedHashMap); // - в обратном порядке, т.к. accessOrder = true + методом гет были использованы элементы с конца

        // Т.е. при вызове элемента - его использование будет ставиться в конец LinkedHashMap.
        // Последний использованный будет последним в Map.

    }
}
