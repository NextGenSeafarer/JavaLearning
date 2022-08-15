package lesson4.Collections.TreeMap;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapGeneral {

    /*
       TreeMap - тип коллекции, при котором хранение данных будет организованно по принципу черно-красного дерева
       Значения TreeMap (Ключи) находятся в отсортированном порядке
       Основа получения элементов treeMap - сравнение, поэтому не переопределенный метод hashCode не будет сильно влиять, но лучше его переопределить!

                            корень
                            ( 5 )
                                \
                               ( 7 ) вершина
                                   \
                                  ( 9 ) вершина
                                      \
                                     ( 100 ) листок
                        Пример добавления элементов в treeMap по возрастанию, получилось несбалансированное дерево,
                        где поиск будет производиться со скоростью O (n), что медленно

                               корень
                              (  7  )
                            /         \
                          (5)        (15) вершины
                        /   \       /    \
                     (3)     (8)  (12)    (18) листья

                     Пример двоичного дерева (только 1 или 2 потомка у каждой вершины), где все элементы слева - меньше,
                     справа - больше
                     тут поиск будет производиться со скоростью O (log n),
                     т.к. такие деревья используют бинарный поиск

        Как только treeMap понимает, что добавление элементов начинает смещаться в одну сторону и выстаиваться в линию -
        происходит перераспределение, для того, чтобы избежать скорости O (n) при линейном проходе по всей ветке.

        Конечные элементы в самом низу называются ЛИСТЬЯМИ.






*/




    public static void main(String[] args) {
        TreeMap<Student, Double> treeMap = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName()); //т.к. treeMap - отсортированная коллекция по ключу - надо использовать переопределение
                // через компаратор, в данном случае - сравнение идет по имени
            }
        });
        Student st1 = new Student("Ilia", "Pochinskii", 26);
        Student st2 = new Student("Daria", "N_N", 27);
        Student st3 = new Student("Kirill", "Pochinskii", 20);
        Student st4 = new Student("Vas", "L_O", 29);
        Student st5 = new Student("Mike", "Json", 18);
        Student st6 = new Student("Van", "Dark", 45);

        treeMap.put(st1, 5.5);
        treeMap.put(st2, 5.7);
        treeMap.put(st3, 5.8); // добавление элементов в TreeMap
        treeMap.put(st4, 6.6);
        treeMap.put(st5, 6.8);
        treeMap.put(st6, 7.2);

        System.out.println(treeMap.descendingMap()); // - если обычная сортировка идет от меньшего к большему, метод descendingMap - от большего к меньшему
        System.out.println(treeMap);

        System.out.println(treeMap.firstEntry()); // первая запись в treeMap
        System.out.println(treeMap.lastEntry()); // последняя запись в treeMap
        System.out.println();

        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        treeMap1.put(1, "One");
        treeMap1.put(5, "Five");
        treeMap1.put(12, "Twelve");
        treeMap1.put(20, "Twenty");

        System.out.println(treeMap1.tailMap(3)); // все элементы начиная с 3, т.е значение может быть любое, даже которого нет в treemap
        System.out.println(treeMap1.headMap(10)); // все элементы начиная до 10, т.е значение может быть любое, даже которого нет в treemap


    }


}

final class Student {
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    private final String name;
    private final String surname;
    private final int age;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}