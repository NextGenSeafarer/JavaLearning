package lesson4.Collections.ListIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {

       /*
       Задача на проверку палиндрома - т.е. читается ли слово с начала и с конца одинаково или нет
       далее представлен просто пример работы интерфейса List Iterator

       методы:
       .hasNext - boolean
       .hasPrevious - boolean
       .next - возвращает следующий элемент
       .previous - возвращает предыдущий элемент



       Минусы: работает только с латиницей!




     */


        String a = "Sum summus mus"; // Я - сильнейшая мышь с латинского
        String s = a.replaceAll(" ", "").toLowerCase();

        List<Character> list = new LinkedList<>();

        for (char ch : s.toCharArray()) {

            list.add(ch);

        }

        ListIterator<Character> listIterator = list.listIterator(); // by default, started from element [0]
        ListIterator<Character> reverseListIterator = list.listIterator(list.size()); // начинает с конца

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
