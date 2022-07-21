package lesson4.Collections.Vector;

import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {

/*
      Вектор - один из устаревших видов коллекции, который является synchronized, т.е. предназначен для многопоточности
      В него могут добавлять элементы и удалять их в несколько пользователей одновременно (т.е. это возможно путем
      блокировки изменения вектора в момент, пока кто - то его изменяет), что крайне сильно замедляет его работу.
      Методы:
      .add
      .get
      .remove
      .firstElement
      .lastElement

*/

        Vector<String> vector = new Vector<>();
        vector.add("Ilia");
        vector.add("Kirill");
        vector.add("Daria");
        vector.add("Bonya");
        System.out.println(vector);
        System.out.println("1st element: " + vector.firstElement());
        System.out.println("last element: " + vector.lastElement());
        vector.remove(0);
        System.out.println("removed Ilia: " + vector);



    }


}
