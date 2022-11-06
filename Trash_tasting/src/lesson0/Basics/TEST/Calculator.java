package lesson0.Basics.TEST;

public class Calculator {


    public static void main(String... args) {

        Calculator calculator = new Calculator();
        System.out.println("Your result is: " +
                calculator.calculate("1/0"));



    }

    public double calculate(String ar) {


        String inputOperator = ar.replaceAll("[\\d ]", "");
        double firstNumber = Double.parseDouble(ar.replaceAll(" ", "").substring(0, ar.indexOf(inputOperator)));
        double secondNumber = Double.parseDouble(ar.replaceAll(" ", "").substring(ar.indexOf(inputOperator) + 1));

        switch (inputOperator) {
            case "+" -> {
                return firstNumber + secondNumber;
            }
            case "-" -> {
                return firstNumber - secondNumber;
            }
            case "/" -> {
                return firstNumber / secondNumber;
            }
            case "*" -> {
                return firstNumber * secondNumber;
            }
        }


        return 0;

    }


}
