package lesson4.Collections.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class arrayLists {
    public static void main(String[] args) {

/*
        ArrayList - это динамически изменяемый массив, необходимый для хранения любых типов данных
*/

//        методы создания ArrayList

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("st1");
        list1.add("st2");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("st3");
        list2.add("st4");

        ArrayList<String> listFromList = new ArrayList<>(list2); // копирование ArrayList

        List<String> list3 = new ArrayList<>();
        list3.add("st5");
        list3.add("st6");


        List list4 = new ArrayList(); //можно в лист поместить всё что угодно
        list4.add(4.22);
        list4.add("STROKA");
        list4.add(new StringBuffer());


        //initial capacity - полезная функция для улучшения производительности
        ArrayList<Integer> list5 = new ArrayList<>(200); // - тогда, при добавлении 201 элемента будет
        //произведено расширение, а не каждый раз
    }
}
