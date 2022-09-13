package lesson6.LambdaExpressions.util.functions.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class removeIfTest {
    public static void main(String[] args) {
        ArrayList<String> listForTestRemoveIf = new ArrayList<>();
        listForTestRemoveIf.add("Hi!");
        listForTestRemoveIf.add("See you!");
        listForTestRemoveIf.add("How is going?");
        listForTestRemoveIf.add("Well");

        System.out.println("before\n" + listForTestRemoveIf);
        listForTestRemoveIf.removeIf(element -> element.length() > 7); // лямбда с Predicate на удаление элементов из листа

        System.out.println("after\n" + listForTestRemoveIf);
        System.out.println("------------------------------------");

        // либо же можно написать заранее определив лямбда выражение
        Predicate<String> lambdaPredicate = (element) -> element.length() > 7;
        Predicate<String> lambdaPredicate2 = (element) -> element.matches("\\w+");
        listForTestRemoveIf.removeIf(lambdaPredicate.and(lambdaPredicate2));

        //Реализация через анонимный класс
        listForTestRemoveIf.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equalsIgnoreCase("Hi!");
            }
        });
        System.out.println(listForTestRemoveIf);
    }
}
