package GamesAndSmallPrograms.MyFirstCalculatorArabicAndRomeNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class userInput {
    static String userInputString;
    private boolean isNotNeededNext;

    void input() {
        System.out.println("Enter your value");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            userInputString = reader.readLine();
            reader.close();
            if (userInputString == null || userInputString.length() == 0 ||
                    userInputString.replaceAll("[/*+\\-\\dIVX]", "").strip().length() > 0 ||
                    userInputString.length() < 3) {
                throw new IOException();
            }
        } catch (IOException e) {
            isNotNeededNext = true;
            System.err.println("please enter correct value");
        }
    }

    void checkInput() {
        if (isNotNeededNext) {
            return;
        }
        String correctString = userInputString.replaceAll("\\s", "").replaceAll("\\W", " ");
        String operator = userInputString.replaceAll("[\\dIVX]", "").strip();
        String[] splitString = correctString.split(" ");
        letsCalculate letsCalculate = new letsCalculate();
        letsCalculate.setOperation(operator);

        if (ArabicAndRimNumbers.rimNumbers.containsKey(splitString[0]) &&
                ArabicAndRimNumbers.rimNumbers.containsKey(splitString[1])) {
            System.err.println("looks like its Rome numbers");
            letsCalculate.setFirstNumber(ArabicAndRimNumbers.rimNumbers.get(splitString[0]));
            letsCalculate.setSecondNumber(ArabicAndRimNumbers.rimNumbers.get(splitString[1]));
            if (letsCalculate.resultOfCalculation() <= 0) {
                throw new RuntimeException();
            }
            System.out.println(ArabicAndRimNumbers.listFrom1to100[letsCalculate.resultOfCalculation() - 1]);
            return;
        }
        if (ArabicAndRimNumbers.arabicNumbers.contains(splitString[0]) &&
                ArabicAndRimNumbers.arabicNumbers.contains(splitString[1])) {
            System.err.println("looks like its Arabic numbers");
            letsCalculate.setFirstNumber(Integer.parseInt(splitString[0]));
            letsCalculate.setSecondNumber(Integer.parseInt(splitString[1]));
            System.out.println(letsCalculate.resultOfCalculation());
            return;
        }
        System.err.println("Something wrong");
        throw new RuntimeException();

    }


}
