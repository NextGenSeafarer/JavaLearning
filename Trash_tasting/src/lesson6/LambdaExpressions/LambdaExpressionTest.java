package lesson6.LambdaExpressions;

public class LambdaExpressionTest {
    public static void main(String[] args) {


        printThis((suffix, prefix, counter) ->
        {
            System.out.println(prefix);
            System.out.println("Meow " + suffix);
            System.out.println(counter);
        });
    }

    ;


    static void printThis(myFunctionalInterface someObject) {
        someObject.printMeSomething("!", "Who said ", 1);
    }


}

@FunctionalInterface // аннотация, которая обозначает функциональный интерфейс - интерфейс с 1 методом
interface myFunctionalInterface {
    void printMeSomething(String suffix, String prefix, int counter);
}

;

