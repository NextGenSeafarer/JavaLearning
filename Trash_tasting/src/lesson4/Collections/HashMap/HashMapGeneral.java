package lesson4.Collections.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapGeneral {
    public static void main(String[] args) {
/*
        HashMap - отдельностоящая коллекция, которая хранит данные по типу ключ-значение
        Получение элементов происходит очень быстро за счет хэш-функции,
        HashMap не хранит порядок вставки элементов

        HashMap - это массив, элементами (или bucket - т.е. корзинами) которого являются LinkedList, в которые записываются
        следующие значения:
        1. Hash code ключа.
        2. Значение ключа;
        3. Значение value;
        4. ссылка на следующий элемент


        map.put(Student4, 500);
        вычисляется hash code ключа Student4, далее идет проверка на null ключа, если он null - тогда запись происходит в начало map, иначе,
        по формуле внутри класса map вычисляется его индекс, туда и помещается hashCode, ключ, value, и ссылка, если же пока там нет другого элемента -
        ссылка будет null.
        При совпадении hash code у 2 элементов (в случае коллизии) - будет произведена  проверка на equals значений этих ключей, если окажется, что они равны -
        тогда значение value будет также перезаписано.

        То же самое при методе
        map.get(Student4) - идет вычисление hash code для ключа Student4, далее его индекс (по формуле, исходя из hash code), далее идет проверка элементов на данном индексе,
        по hash code, затем через equals будут сравнены искомый и имеющийся ключ, и если всё ок - тогда вернется значение value.


        HashMap <> (16, 0.75) - где 16 - начальный размер hashmap и 0.75 - его load factor, т.е. 16 х 0.75 = 12,
        при заполнении 12 из 16 ячеек hashmap - он будет удвоен и скопирован в новый.
        Начиная с java 8 - после определенного размера hashmap - метод хранения в связанных списках будет заменен на
        сбалансированные деревья, для улучшения производительности, потому что если поиск hashcode выполняется со скоростью O(1) - в лучшем случае,
        тогда перебор всех элементов в LinkedList - O (n), что сильно влияет на производительность, при этом в сбалансированных деревьях производится
        бинарный поиск со скоростью O (log n), что быстрее чем O (n).

        Важно: скорость работы hashMap определяется тем, на сколько хорошо определен метод hashCode. Операции вставки (put) и (get) для hashmap -
        в лучшим случае постоянная - O(1), в худшем - O(n), т.е. когда идет поиск по hashcode в самом листе.

        Для ключа в hashMap необходимо использовать только immutable классы, т.е. те, которые не имею наследников, не могут быть изменены извне,
        поля данных классов и сами классы, соответсвенно, должны быть final (+ инкапсуляция private доступ),  т.к. мы знаем, что на формирование hashcode влияют все поля и,
        изменив одно - уже невозможно будет найти данный элемент. Изменилось поле в методе - изменился hashcode.

        + ниже пример с Map. Entry - интерфейсом класса Map для получения пар ключ - значение

*/
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("First", 1);
        stringIntegerMap.put("Second", 2);
        stringIntegerMap.put("Third", 3);
        stringIntegerMap.put("Fourth", 4);

        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            System.out.println("ключ : " + entry.getKey() + ", значение : " + entry.getValue());
        }
        System.out.println(stringIntegerMap.get("Second"));


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
