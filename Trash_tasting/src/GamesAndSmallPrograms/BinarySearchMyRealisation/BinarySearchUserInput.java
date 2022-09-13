package GamesAndSmallPrograms.BinarySearchMyRealisation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchUserInput {

    private static String userInputString; // user input
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // user input
    private static long[] range = {0, 0}; // to keep the range of numbers for search
    private static long rangeOriginal; //for statistics only
    private static int counterForRange = 0; // counterForRange == 0 -> range [0] change | == 1 -> range [1] change
    private static long guessNumber; // guessNumber - middle of the range remains for search
    private static final List<Long> filledRange = new ArrayList<>(); // list for keeps values withing range assigned
    private static int totalAttemptsNumber = 0; // counter for attempts

    public static long getRangeOriginal() {
        return rangeOriginal;
    }

    public static long getGuessNumber() {
        return guessNumber;
    }


    public static void userRandomRangeInput() { // method for getting range of numbers from user
        while (true) {
            if (counterForRange == 0) {
                BinarySearchTexting.messageForBeginningOfRange();
            }
            if (counterForRange != 0) {
                BinarySearchTexting.messageForEndOfRange();
            }
            try {
                userInputString = reader.readLine();
                if (userInputString == null || userInputString.equals("")) {
                    System.err.println("Can't be empty/null");
                    continue;
                }
                if (userInputString.matches("-?\\d+") && counterForRange == 0) {
                    range[0] = Long.parseLong(userInputString);
                    counterForRange++;
                    continue;
                }
                if (userInputString.matches("-?\\d+")) {
                    if (Long.parseLong(userInputString) <= range[0]) {
                        System.err.println("Second number can't be less or equal!");
                        continue;
                    }
                    range[1] = Long.parseLong(userInputString);
                    if (range[1] - range[0] > 9999999) {
                        System.out.println("Sorry, I'm not strong enough for such big numbers(");
                        continue;
                    }
                    System.out.println("Your range is from " + range[0] + " to " + range[1]);
                    for (long i = range[0]; i <= range[1]; i++) {
                        filledRange.add(i);
                        rangeOriginal++;
                    }
                    if (rangeOriginal % 2 != 0) {
                        guessNumber = filledRange.get(filledRange.size() / 2);
                    } else {
                        guessNumber = filledRange.get(filledRange.size() / 2) - 1;
                    }
                    // filling up the list within the range and assign guess number
                    break;
                }
                System.err.println("Please enter only numbers!"); // just reminder to put only the numbers
            } catch (IOException e) {
                System.out.println("Some banana happened :( "); // obviously, some banana happened
                throw new RuntimeException(e);
            }
        }
    }

    public static void askForMoreOrLess() { // method for finding the guess number
        while (true) {
            try {
                userInputString = reader.readLine();
                if (userInputString.matches("[MmLlYy]")) {
                    switch (userInputString) {
                        case "M", "m" -> {
                            if (filledRange.size() == 2) { // that loop to be finished when the guessed number found
                                System.out.println("Your number is: " + filledRange.get(1) + "?" + "\n");
                                continue;
                            }
                            filledRange.removeIf(integer -> guessNumber >= integer); // removing half of the list numbers
                            guessNumber = filledRange.get(filledRange.size() / 2); // finding the middle of the list number
                            if (filledRange.size() == 1) { // return for the last remains number
                                totalAttemptsNumber++;
                                System.out.println("Your number is: " + guessNumber + "\n");
                                System.err.printf("Total attempts: %d", totalAttemptsNumber);
                                return;
                            }
                            totalAttemptsNumber++;
                            System.out.println("Your number is: " + guessNumber + "?" + "\n");

                        }
                        case "L", "l" -> {
                            if (filledRange.size() == 2) { // that loop to be finished when the guessed number found
                                System.out.println("Your number is: " + filledRange.get(0) + "?" + "\n");
                                continue;
                            }
                            filledRange.removeIf(integer -> guessNumber <= integer); // removing half of the list numbers
                            guessNumber = filledRange.get(filledRange.size() / 2); // finding the middle of the list number
                            if (filledRange.size() == 1) { // return for the last remains number
                                totalAttemptsNumber++;
                                System.out.println("Your number is: " + guessNumber + "\n");
                                System.err.printf("Your total attempts: %d\n", totalAttemptsNumber);
                                return;
                            }
                            totalAttemptsNumber++;
                            System.out.println("Your number is: " + guessNumber + "?" + "\n");
                        }
                        case "Y", "y" -> { // return from the loop once guessed number has been found
                            totalAttemptsNumber++;
                            System.err.printf("Your total attempts: %d\n", totalAttemptsNumber);
                            return;
                        }
                    }
                    continue;
                }
                System.err.println("M for More\nL for Less\nY for Yes! Its my number"); // reminder if wrong symbol was entered
            } catch (IOException e) {
                System.out.println("Some banana happened :( "); // obviously, some banana happened
                throw new RuntimeException(e);
            }
        }
    }
}
