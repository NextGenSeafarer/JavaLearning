package lesson4.Collections.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListLearn {
    public static void main(String[] args) {

        /*
        LinkedList - ��� ���� �� ����������� ������ List, � ������� �������� �������� � ������� �� ���������� � ���������
        ������ � �����.
        ������ ������� LinkedList - head, last element - tail.
        LinkedList ��������� ��������, ���� ���������� ������ ��������� �������� ������� � ��������
        ����� get - ������ ��������������, �.�. �����, �������� ����� ������� ��������� ���������� ������ �� ���� ����������
        ��������� ������� � ������ ��� ������ ���������.
        ������ ��� ���������� ��� �������� �������� ����� �������� ������ ������ �� ������, ������� �� ������ �� ���������
        �������� ���������, ������ ��� ����� ��������� ���������.
         */

        long startTime1 = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1; i++) {
            linkedList.add(i);
        }
        long finishTime1 = System.currentTimeMillis();
        System.out.println("����������� �����: " + (finishTime1 - startTime1) + " ��");

        // 90 - 110 ����������� �� ���������� 1 �������� ��������� � LinkedList  !
        // 1250 ����������� �� ���������� 10 ��������� ��������� � LinkedList    !!!!
        // 13905 ����������� �� ���������� 100 ��������� ��������� � LinkedList  !!!!!!!!!!!!!!!!!


        long startTime2 = System.currentTimeMillis();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        for (int i = 0; i < 1_000_000; i++) {
            linkedList2.add(i);
        }
        System.out.println(linkedList2.get(500_000));
        long finishTime2 = System.currentTimeMillis();
        System.out.println("����������� �����: " + (finishTime2 - startTime2) + " ��");

        // 110 - 125 ����������� �� ���������� 1 �������� ��������� � LinkedList � ��������� 500_000 ��������
        // 1327 ����������� �� ���������� 10 ��������� ��������� � LinkedList � ��������� 5_000_000 ��������
        // 14324 ����������� �� ���������� 100 ��������� ��������� � LinkedList � ��������� 50_000_000 ��������


        /*
        ������� � ��� ������� �� 10 ��������� � ����� �� �� 100 ���������. ����� �������� ArrayList �� �� �� ��������
        */

        long startTime3 = System.currentTimeMillis();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            arrayList1.add(i);
        }
        long finishTime3 = System.currentTimeMillis();
        System.out.println("����������� �����: " + (finishTime3 - startTime3) + " ��");

        // 15 - 36 ����������� �� ���������� 1 �������� ��������� � ArrayList
        // 313 - 360 ����������� �� ���������� 10 ��������� ��������� � ArrayList
        // 2454 - 2550 ����������� �� ���������� 100 ��������� ��������� � ArrayList


        long startTime4 = System.currentTimeMillis();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int j = 0; j < 1; j++) {
            arrayList2.add(j);
        }
        System.out.println(arrayList2.get(0));
        long finishTime4 = System.currentTimeMillis();
        long res = finishTime4 - startTime4;

        System.out.println("����������� �����: " + res + " ��");


        // 15 - 63 ����������� �� ���������� 1 �������� ��������� � ArrayList � ��������� 500_000 ��������
        // 187 - 453 ����������� �� ���������� 10 ��������� ��������� � ArrayList � ��������� 5_000_000 ��������
        // 2413 - 3218 ����������� �� ���������� 100 ��������� ��������� � ArrayList � ��������� 50_000_000 ��������


        /*

        ������������������ ArrayList � ��������� � LinkedList - 3 � ������ 14 � (11 ������) �� 100 ��� ���������
        0.3 � ������ 1.3 � (1 �������) �� 10 ��� ��������� � 0.03 � � 0.11 � (0.08 ������) �� 1 ��� ��������� ��������������

        */


    }

}
