package GamesAndSmallPrograms.RockPaperScissors;

import java.util.Random;

public class ComputerRandom {
    static String generateRandomObject() {
        Random random = new Random();
        int computerObject = random.nextInt(0, 3);
        return switch (computerObject) {
            case 0 -> "Rock";
            case 1 -> "Paper";
            case 2 -> "Scissors";
            default -> throw new IllegalStateException("Unexpected value: " + computerObject);
        };
    }
}
