package GamesAndSmallPrograms.NotCrazyRockPaperScissors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class Game {

    public static void main(String[] args) {

        Game game = new Game();
        System.out.println("Hello to NOT CRAZY Rock, Paper, Scissors game!");

        game.startTheGame();
    }


    private String userInputConsole;

    public String getUserInputConsole() {
        return userInputConsole;
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private final List<String> scissors = List.of("P");
    private final List<String> paper = List.of("R");
    private final List<String> rock = List.of("S");


    public void startTheGame() {
        System.out.println("Input your value (R,P or S)\nEnter E or Exit to finish the game\nEnjoy!\n");

        while (true) {
            try {
                System.out.print("Your input is here -> ");
                userInputConsole = reader.readLine();
                if (userInputConsole.matches("[E|e]") || userInputConsole.equalsIgnoreCase("exit")) {
                    return;
                }
                if (userInputConsole.equals("")) {
                    System.out.println("Input cannot be null or empty! Try again");
                    continue;
                }
                if (userInputConsole.matches("[RPSrps]")) {
                    String computer = ComputerInput.computeObject();
                    System.out.printf("    Computer input -> %s\n", computer);
                    switch (userInputConsole) {
                        case "P", "p" ->
                                System.out.println(computer.equalsIgnoreCase("P") ? "       Draw" : paper.contains(computer) ? "        You Win!" : "       Computer Win!");
                        case "R", "r" ->
                                System.out.println(computer.equalsIgnoreCase("R") ? "       Draw" : rock.contains(computer) ? "       You Win!" : "       Computer Win!");
                        case "S", "s" ->
                                System.out.println(computer.equalsIgnoreCase("S") ? "       Draw" : scissors.contains(computer) ? "       You Win!" : "       Computer Win!");
                    }
                    continue;
                }
                System.out.println("Please enter correct value only!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    class ComputerInput {
        private static final List<String> allObjects = List.of("p", "s", "r");
        private static final Random random = new Random();

        public static String computeObject() {

            return allObjects.get(random.nextInt(0, 3));
        }
    }
}
