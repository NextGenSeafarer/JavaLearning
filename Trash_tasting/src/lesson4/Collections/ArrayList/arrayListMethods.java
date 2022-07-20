package lesson4.Collections.ArrayList;

import java.util.ArrayList;
import java.util.Objects;

public class arrayListMethods {
    public static void main(String[] args) {

        /*
        ������������ ��������� ������� ArrayList:
        .add - ���������� � ���� + �������� � ������������� �������
        .set - ������ �������� � �����
        .get - ��������� �������� ����� �� ��� �������
        .remove - �������� �������� �� ��� ������� ��� ����� ������� ������ ������� �� ����� - �� �������
        .addAll - ���������� � ���� ���� ��������� ������� ����� + �������� � ������������� �������
        .clear - �������� ����
        .size - ������ ����� (���������� ���������)
        .contains - ������ ���������� ��� ����������� ���������� �������� � �����
        .indexOf + .lastIndexOf - ������ � ��������� ������ ����������� ��������
        .isEmpty - ������ ���������� ��� �������� ������ �� ����
        .toString - � List ��� ���������� � �� ������������.��� Generics - ����������� ����� �������������� � ������
        ����� �� ��������� �� ����� ���������� Generic �����

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
//        ��������, � ���� ������� �������� Daria, �� ����� ������� �� �� ��������, ��� ��� ����� equals ������ Object
//        ��������� �� ��������� ������, ���� ����� ��� == , �.�. ������� 4 � ������� 3 ����� ������ ������ � ������� 3 �� ��������
//        ���������� � ������ Student �������������� ����� equals

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
