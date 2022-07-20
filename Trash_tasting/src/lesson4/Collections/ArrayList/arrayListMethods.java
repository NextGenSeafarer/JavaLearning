package lesson4.Collections.ArrayList;

import java.util.ArrayList;
import java.util.Objects;

public class arrayListMethods {
    public static void main(String[] args) {

        /*
        Перечисление возможных методов ArrayList:
        .add - добавление в лист + возможно с определенного индекса
        .set - замена элемента в листе
        .get - получение элемента листа по его индексу
        .remove - удаление элемента по его объекту или можно удалить просто элемент на каком - то индексе
        .addAll - добавление в лист всех элементов другого листа + возможно с определенного индекса
        .clear - очистить лист
        .size - размер листа (количество элементов)
        .contains - булева переменная для определения нахождения элемента в листе
        .indexOf + .lastIndexOf - первый и последний индекс переданного элемента
        .isEmpty - булева переменная для проверки пустой ли лист
        .toString - у List уже определена и не используется.Для Generics - обязательно нужно переопределить в методе
        иначе не выведется на экран содержимое Generic листа

         */




        Student student1= new Student("Ilia","Pochinskii","M",26,5);
        Student student2= new Student("Kirill","Pochinskii","M",19,4);
        Student student3= new Student("Daria","Pochinskaia","F",27,3);

        ArrayList<Student> list1 = new ArrayList<>();
        list1.add(student1);
        list1.add(student2);
        list1.add(student3);
        System.out.println(list1);


//        Student student4 = new Student("Daria","Pochinskaia","F",27,3);
//        list1.remove(student4);
//        System.out.println(list1);
//        Допустим, я хочу удалить студента Daria, но таким образом он не удалится, так как метод equals класса Object
//        определен на сравнение ссылок, тоже самое что == , т.е. студент 4 и студент 3 имеют разные ссылки и студент 3 не удалится
//        необходимо в классе Student переопределить метод equals

          Student student4 = new Student("Daria", "Pochinskaia", "F", 27, 3);
          list1.remove(student4);
          System.out.println(list1);


    }
}

class Student {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && avg == student.avg && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(sex, student.sex);
    }



    private String name;
    private String surname;
    private String sex;
    private int age;
    private int avg;

    public Student(String name, String surname, String sex, int age, int avg) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", avg=" + avg +
                '}';
    }
}
