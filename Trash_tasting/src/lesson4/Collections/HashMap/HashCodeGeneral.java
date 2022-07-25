package lesson4.Collections.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeGeneral {
    public static void main(String[] args) {

/*
        HashCode - метод, необходимый для сравнения объектов в таких структурах как HashMap, HashSet и т.д.
        1. Если метод equals возвращает true, то hashCode обязательно должен быть одинаковым у обоих объектов
        2. Если метод equals возвращает false, то hashCode НЕ должен быть разным (может быть и одинаковым) !
        3. Переопределил equals - переопредели и hashCode
        4. Ситуация при которой hashcode разных объектов одинаковы - называется коллизией, чем их меньше - тем лучше
        Почему так случается?
        Если посмотреть на метод hashCode()

        @Override
        public int hashCode() {
        return Objects.hash(name, surname, age);
        }
        Становится понятно, что данный метод возвращает int значение, которое ограниченно ~2.1 млрд положительных значений
        и ~2.1 млрд отрицательных значений. (Hashcode может быть ОТРИЦАТЕЛЬНЫМ).
        Поэтому становится ясно - можно создать 5 млрд объектов и даже если метод hashCode написан идеально - коллизия всё равно
        случится, так как значений типа int просто будет недостаточно.

        5. Метод hashCode должен быть определен так, чтобы при всех вызовах данного метода у одного объекта - значение оставалось всегда
        одинаковым

        Дефолтная реализация хешкода в Object подразумевает использование адреса объекта, поэтому не переопределив .hashCode
        даже при абсолютно одинаковых объектах hashCode будет разным, потому что посути дефолтная реализация, как и для equals
        это просто сравнение через " == ". А у двух объектов не может быть одинаковых ссылок (исключение - готовые классы типа String, Integer, Character и тд),
        которые будут ссылаться на одни и те же объекты в памяти (String pool, Integer pool и тд).
        Поэтому создав 2 млрд студентов с одинаковыми полями, но не переопределив hashCode метод - они все будут иметь разные hashCode.


*/

        Map<Student, Double> studentMarks = new HashMap<>();
        Student student1 = new Student("Vasya", "Bikov", 22);
        Student student2 = new Student("Olya", "Olyalya", 23);
        Student student3 = new Student("Papich", "Arthas", 29);
        Student student4 = new Student("Papich", "Arthas", 29);
        Student student5 = new Student("Papich", "Arthas", 29);
        Student student6 = new Student("Papich", "Arthas", 29);
        Student student7 = new Student("Papich", "Arthas", 29);
        studentMarks.put(student1, 3.5);
        studentMarks.put(student2, 4.1);
        studentMarks.put(student3, 8.8);

        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student3.hashCode()); // - hashcode для папичей одинаковый при переопределенном методе hashCode и разный при не переопределенном
        System.out.println(student4.hashCode()); // - hashcode для папичей одинаковый при переопределенном методе hashCode и разный при не переопределенном
        System.out.println(student5.hashCode()); // - hashcode для папичей одинаковый при переопределенном методе hashCode и разный при не переопределенном
        System.out.println(student6.hashCode()); // - hashcode для папичей одинаковый при переопределенном методе hashCode и разный при не переопределенном
        System.out.println(student7.hashCode()); // - hashcode для папичей одинаковый при переопределенном методе hashCode и разный при не переопределенном
        System.out.println(student3.equals(student4));

    }
}

class Student {
    String name;
    String surname;
    int age;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
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
