package lesson4.Collections.BinarySearchExamples;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearch1 {
    public static void main(String[] args) {

        /*
        Binary search - ���� �� ����� ����������� ������� ������ ��������� � ������������� �������� � ����������.
        ������ / ��������� ������� ������� � ��������� ������ ������������ � �������
        ����� ������� ������� ������� ����� ���� ������ ��� ��������� �������� �� O(log n), ������ O(1)
        �������� ����� ����������� ���� � ������� ������� ������, ��� ��������� �������� �������� ����� ����� ����
        ����� ����������������, �.�. ��� �� ����� ����� �������������� �����������

        ��������:
        ArrayList <Integer> list = new ArrayList<>();
        list.add(0);
        list.add(-12);
        list.add(4);
        list.add(8);
        list.add(-1);
        Collections.sort(list);
        list ����� ��������� ��� [-12, -1 , 0 , 4, 8]
        ����� Collections.binarySearch(list, 8) ����� ��������� �������� �� 2 ����
        0<8? �� (��, ��� ������ 0 ������������� ����� ��)
        4<8? �� (��, ��� ������ 4 ������������� ����� ��)
        �������� 8
        ���� �� ����� ����������� ������ ��������� - ����� ��� ������ ���� ��������� ����� ����� ���� �� � 5 �������
        */

        ArrayList<BinaryEmployee> list = new ArrayList<>();

        BinaryEmployee e1 = new BinaryEmployee(12, "Vasya", 2000);
        BinaryEmployee e2 = new BinaryEmployee(5, "Kolya", 3211);
        BinaryEmployee e3 = new BinaryEmployee(120, "Tanya", 300);
        BinaryEmployee e4 = new BinaryEmployee(12, "Mr.Stajor", 0);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        System.out.println(list);
        Collections.sort(list); //�������������, �������� ��������� Comparable
        System.out.println(list);
        int indexOfVasya = Collections.binarySearch(list, new BinaryEmployee(12, "Vasya", 0)); //salary ����� ���� ����� ������
        //�.� �� �� ����������� �� �������� � ������ compareTo
        System.out.println(indexOfVasya);

        //����� ����� ��� �������� � ��� ��������
        int[] array = {-5, 0, 12, -20, 4, 7};
        System.out.println("not sorted: " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("sorted: " + Arrays.toString(array));
        int indexOfFour = Arrays.binarySearch(array,4);
        System.out.println(indexOfFour);
    }
}

class BinaryEmployee implements Comparable<BinaryEmployee> {
    private int id;
    private String name;
    private int salary;


    public BinaryEmployee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "BinaryEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(BinaryEmployee o) {
        if (this.id < o.id) {
            return -1;
        }
        if (this.id > o.id) {
            return 1;
        }

        return this.name.compareTo(o.name);

    }
}
