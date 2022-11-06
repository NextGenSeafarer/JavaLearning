package lesson7.LambdaExpressions.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduce {

    /*
    Перебирает все элементы и оставляет только один,
    содержит в себе accumulator и element составляющие
    Если изначальное значение для accumulator не задано - accumulator будет присвоен первый элемент

     */


    public static void main(String[] args) {

        //допустим как я могу посчитать сумму элементов массива:
        System.out.println("<--------------------BEFORE------------------------>");

        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("My Array is: " + Arrays.toString(array));
        System.out.printf("My sum is : %d", sum);

        System.out.println("<--------------------Reduce method------------------------>");

        System.out.println("My Array STREAM is : " + Arrays.toString(array));
        System.out.println("My sum is : " + Arrays.stream(array).reduce((accumulator, element) -> accumulator + element).getAsInt());
        // метод get выводит на экран значение accumulator (либо может быть getAsInt)
        // но иногда значения может и не быть, если вызывается метод reduce на пустой массив

        System.out.println("<--------------------Reduce method with empty Array------------------------>");
        List<Integer> list = new ArrayList<>();
        //list.stream().reduce((a, e) -> a + e).get(); //выбросит NoSuchElementException
        //поэтому стоит либо задавать изначальный accumulator:
        System.out.println("Identity: " + list.stream().reduce(1, (a, e) -> a + e)); // тогда в любом случае вернется что - то
        //либо же сохранять переменную в Optional и через isPresent проверять, что она не null, дабы избежать exception

        Optional<Integer> optional = list.stream().reduce((a, e) -> a + e);
        if(optional.isPresent()){
            System.out.println(optional);
        }
        System.out.println("No such element!");


    }
}
