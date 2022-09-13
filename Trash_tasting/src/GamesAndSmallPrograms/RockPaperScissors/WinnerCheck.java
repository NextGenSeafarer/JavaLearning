package GamesAndSmallPrograms.RockPaperScissors;

public class WinnerCheck {
    private static String compValue;
    private static String userInput;
    private static int userWinsCounter = 0;
    private static int computerWinsCounter = 0;
    private static int totalCount = 0;

    public static int getUserWinsCounter() {
        return userWinsCounter;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    public static int getComputerWinsCounter() {
        return computerWinsCounter;
    }

    static void winnerShow() {
        userInput = UserInputRockPaperScissors.getObject();
        compValue = ComputerRandom.generateRandomObject();
        totalCount++;
        if (userInput.equals(compValue)) {
            System.out.println("Both throw " + compValue + " No winner!");
            return;
        }
        if (userInput.equals("Rock")) {
            if (compValue.equals("Scissors")) {
                System.out.println("Rock beats Scissors YOU WIN!");
                userWinsCounter++;
                return;
            }
            if (compValue.equals("Paper")) {
                System.out.println("Paper beats Rock COMPUTER WIN!");
                computerWinsCounter++;
                return;
            }

        }
        if (userInput.equals("Paper")) {
            if (compValue.equals("Scissors")) {
                System.out.println("Scissors beats Paper COMPUTER WIN!");
                computerWinsCounter++;
                return;
            }
            if (compValue.equals("Rock")) {
                System.out.println("Paper beats Rock YOU WIN!");
                userWinsCounter++;
                return;
            }

        }
        if (userInput.equals("Scissors")) {
            if (compValue.equals("Paper")) {
                System.out.println("Scissors beats Paper YOU WIN!");
                userWinsCounter++;
                return;
            }
            if (compValue.equals("Rock")) {
                System.out.println("Rock beats Scissors COMPUTER WIN!");
                computerWinsCounter++;
                return;
            }
        }


    }


}
