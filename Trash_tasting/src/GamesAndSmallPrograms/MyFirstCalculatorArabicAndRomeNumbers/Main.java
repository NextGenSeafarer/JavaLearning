package GamesAndSmallPrograms.MyFirstCalculatorArabicAndRomeNumbers;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
        Реализация калькулятора, который принимает либо арабские, либо
        римские цифры на вход и 4 операции: сложения, вычитания, деления, умножения
        Римские цифры могут быть только с римскими цифрами
        Арабские только с арабскими
        */
        userInput userInput = new userInput();
        userInput.input();
        userInput.checkInput();
    }
}
