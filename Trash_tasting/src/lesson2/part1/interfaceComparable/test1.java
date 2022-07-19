package lesson2.part1.interfaceComparable;

import java.util.ArrayList;
import java.util.Collections;

public class test1 {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "A", 300);
        Employee employee2 = new Employee(2, "C", 1000);
        Employee employee3 = new Employee(4, "V", 900);
        Employee employee4 = new Employee(3, "B", 400);

        ArrayList<Employee> list = new ArrayList<>(); // создаем ArrayList с объектами класса Employee
        list.add(employee1); //добавляем работников
        list.add(employee2); //добавляем работников
        list.add(employee3); //добавляем работников
        list.add(employee4); //добавляем работников

        System.out.println("list before sorting: " + list);

          Collections.sort(list); // механизм сортировки прописан в методе compareTo
//        Collections.sort(list, new NameComparator()); // данный метод сортировки ссылается на класс NameComparator
//        Collections.sort(list, new IdComparator()); // данный метод сортировки ссылается на класс IdComparator
//        можно использовать натуральную сортировку, но при необходимости добавлять сортировку через класс, имплементирующий Comparator

        System.out.println("list after sorting: " + list);

        /* Интерфейс (implements Comparable<Employee>) - позволяет создать собственный принцип сортировки.
        В данном случае сортировка производится по зарплате в натуральном ордере, от min to max.
        Метод compareTo - единственный метод интерфейса Comparable, который мы переопределяем

        !!! при добавлении метода в Collection.sort(list, new NameComparator()) - NameComparator будет в приоритете
        т.е сортировка будет проводится по нему

        Можно использовать такую сортировку для сортировки по количеству символов
        return (employee1.name.length() - employee2.name.length());

        Или вывести строки или Id не в натуральном ордере, а в обратном

        */







    }
}

