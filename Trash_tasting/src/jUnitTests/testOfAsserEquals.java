package jUnitTests;

public class testOfAsserEquals {



    public static int divider(int a, int b) {
        if (a == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static String test(String input) {
        String allNumbersReplacedWithBlank = input.replaceAll("\\d", "");
        if (allNumbersReplacedWithBlank.length() == 0) {
            throw new RuntimeException() {
            };
        }
        return allNumbersReplacedWithBlank;
    }

    public static boolean isFirstNumberBiggerThanSecond(int a, int b) {
        return a > b;
    }

    public static double averageGrade(double[] grades) {
        double average = 0;
        for (double grade : grades) {
            average += grade;
        }
        return average / grades.length -1 ;
    }


}
