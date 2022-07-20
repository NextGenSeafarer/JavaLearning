package lesson4.Collections.ListIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {

       /*
       ������ �� �������� ���������� - �.�. �������� �� ����� � ������ � � ����� ��������� ��� ���
       ����� ����������� ������ ������ ������ ���������� List Iterator

       ������: �������� ������ � ���������!


       */


        String a = "Sum summus mus"; // � - ���������� ���� � ����������
        String s = a.replaceAll(" ", "").toLowerCase();

        List<Character> list = new LinkedList<>();

        for (char ch : s.toCharArray()) {

            list.add(ch);

        }

        ListIterator<Character> listIterator = list.listIterator(); // by default, started from element [0]
        ListIterator<Character> reverseListIterator = list.listIterator(list.size()); // �������� � �����

        boolean isPalindrome = true;

        while (listIterator.hasNext() && reverseListIterator.hasPrevious()) {
            if (listIterator.next() != reverseListIterator.previous()) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("Word is palindrome");
        } else {
            System.out.println("Not palindrome");
        }


    }

}
