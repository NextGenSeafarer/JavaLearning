package GamesAndSmallPrograms.RockPaperScissors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputRockPaperScissors {
    private static String input;
    private static String object;
    private boolean isNeedToFinish;

    public boolean isNeedToFinish() {
        return isNeedToFinish;
    }

    public static String getObject() {
        return object;
    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    void userInputCheck() {
        try {
            while (true) {
                if (isNeedToFinish) {
                    reader.close();
                    return;
                }
                input = reader.readLine();
                if (input == null || input.equals("")) {
                    System.err.println("Input is not to be blank");
                    continue;
                }
                if (input.matches("[Ee]")) {
                    isNeedToFinish = true;
                    break;
                }
                if (input.matches("\\?")) {
                    System.err.println("\n" + "You: " + WinnerCheck.getUserWinsCounter() + "\n" +
                            "Computer: " + WinnerCheck.getComputerWinsCounter());
                    Thread.sleep(1200);
                    System.out.println("\nPlease enter Rock (R), Paper (P) or Scissors (S)");
                    continue;
                }
                if (input.matches("[rpsRPS]")) {
                    switch (input) {
                        case "R", "r" -> {
                            object = "Rock";
                        }
                        case "P", "p" -> {
                            object = "Paper";
                        }
                        case "S", "s" -> {
                            object = "Scissors";
                        }
                    }
                    break;
                }
                System.err.println("Please enter only R or P or S");
                continue;
            }
        } catch (IOException e) {
            System.out.println("Something goes wrong");
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
