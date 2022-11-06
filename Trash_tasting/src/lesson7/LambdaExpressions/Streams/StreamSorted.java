package lesson7.LambdaExpressions.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamSorted {

/*
        sorted() - делает сортировку (НЕОЖИДАННО)
*/

    public static void main(String[] args) {

        int[] array = {4, 2, 3, 7, -2, 19, -100};
        System.out.println("ORIGINAL:");
        Arrays.stream(array).forEach(System.out::println);
        System.out.println("-------------------------------");
        System.out.println("SORTED:");
        Arrays.stream(array).sorted().forEach(System.out::println);
        System.out.println("-------------------------------");

        List<SomeMan> someManList = new ArrayList<>();
        someManList.add(new SomeMan("Alesha", 26));
        someManList.add(new SomeMan("Vasya", 12));
        someManList.add(new SomeMan("Grisha", 33));
        someManList.add(new SomeMan("Olya", 90));

        someManList.stream()
                .sorted((somePerson1, somePerson2) -> somePerson1.getAge() - somePerson2.getAge())
                .forEach(System.out::println); // Внезапно выполняем сортировку по возрасту
    }
}

class SomeMan {
    String name;
    int age;


    public SomeMan(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Person name: " + name + ", age: " + age;
    }

}
