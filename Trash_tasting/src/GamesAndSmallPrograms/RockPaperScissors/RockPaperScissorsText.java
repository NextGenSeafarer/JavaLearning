package GamesAndSmallPrograms.RockPaperScissors;

public class RockPaperScissorsText {
    static void textToShowBeginning() {
        System.out.println("Please enter Rock (R), Paper (P) or Scissors (S)");
        System.out.println("Enter \"E\" to exit the game\nEnter \"?\" to see the score");
    }

    static void textToShowIfEnd() {
        System.err.println("\nGame is over");
        System.out.println("FINAL SCORE \n" + "You: "
                + WinnerCheck.getUserWinsCounter() + "\nComputer: "
                + WinnerCheck.getComputerWinsCounter() +
                "\nTotal Games: " + WinnerCheck.getTotalCount());
    }

}
