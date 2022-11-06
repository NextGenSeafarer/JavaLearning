package lesson7.LambdaExpressions.Streams;

import java.util.Arrays;

public class StreamForEach {
    public static void main(String[] args) {

        /*
        forEach - возвращает void и является terminate методом
        необходим для перебора всех элементов стрима, удобен для вывода на экран
        */

        int[] array = {1, 3, 6, 7, 10};
        Arrays.stream(array).forEach(i -> {
            i = i * 2;
            System.out.println(i);
        });

        System.out.println("-------------------------------------------------\n");
        Arrays.stream(array).forEach(System.out::println);// удобный вывод на экран через метод референс
        //Arrays.stream(array).forEach(i -> System.out.println(i)); то же самое

        System.out.println("-------------------------------------------------\n");
        Arrays.stream(array).forEach(StreamForEach::methodExample); // я передаю метод, который содержится в моем классе
        // Java подставляет переданные элементы Stream (array) в метод, который как раз и принимает int


    }

    public static void methodExample(int i) {
        i += 10;
        System.out.printf("Element is = %d\n", i);
    }
}
