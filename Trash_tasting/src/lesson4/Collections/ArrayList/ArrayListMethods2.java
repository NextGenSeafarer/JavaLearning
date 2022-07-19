package lesson4.Collections.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods2 {
    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Ilia");
        list1.add("Kirill");


        ArrayList<String> list2 = new ArrayList<>(list1);
        list2.add("Daria");

        list2.removeAll(list1); //list2.removeAll (Collection <?> c) - ������� ��� �������� ��������� 1 �� ��������� 2

        list2.retainAll(list1); //list2.retainAll (Collection <?> c) - ��������� ��� �������� ��������� 1 � ��������� 2

        boolean isContains = list2.containsAll(list1); //���� ��� �������� ��������� 2 �������� ��������� 1

        List<String> list3 = list2.subList(0, 1);
        // ������� sublist
        // ���� ���� sublist - ������ �������� ���� �� �������� �� ������ ��������, ���������� �������� sublist
        // �������, ����������� � sublist - ����� �������� � � ������� ���� ����

        String[] array = list1.toArray(new String[0]); //�������� ������� �� �����
        //����������� ������� = 0, ����� java ���� ���������� �����������, ������ �� list1.size

        List<Integer> intList = List.of(1, 2, 3); //������� �������� ����� � ������������ �������
        // ������ ��������������!!! ������ ��������� NULL


        List<String> list4 = List.copyOf(list1); //������� ����������� ����� � ������������ �������
        // ������ ��������������!!! ������ ��������� NULL

    }
}
