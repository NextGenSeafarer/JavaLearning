package lesson4.Collections.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapGeneral {
    public static void main(String[] args) {
/*
        HashMap - отдельностоящая коллекция, которая хранит данные по типу ключ-значение
        Получение элементов происходит очень быстро за счет хэш-функции,
        HashMap не хранит порядок вставки элементов




*/
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(10, "Test_String0");
        map1.put(12, "Test_String1");
        map1.put(4, "Test_String2");
        map1.putIfAbsent(111, "PUT_IF_ABSENT"); // - добавляет переданную пару, если такого ключа ещё не было
        System.out.println(map1);
        map1.remove(10); // - удаляем пару по ключу
        System.out.println(map1);
        System.out.println(map1.get(12)); // - получаем значение по ключу
        System.out.println(map1.values()); // - получаем все значения
        System.out.println(map1.keySet()); // - получаем все ключи
        System.out.println(map1.entrySet()); // - получаем все пары из hashmap
        System.out.println(map1.containsKey(12)); // - булева переменная, проверяет на содержание hashMap переданного ключа
        System.out.println(map1.containsValue("Test_String1")); // - булева переменная, проверяет hashmap на содержание данного значения




    }
}
