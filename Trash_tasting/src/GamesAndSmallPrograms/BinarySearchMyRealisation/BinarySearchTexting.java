package GamesAndSmallPrograms.BinarySearchMyRealisation;

public class BinarySearchTexting {


    static void welcomeMessage() {
        System.out.println("Hello! Just think about some number in random range\n" +
                "I'll show how to find it using binary search");
    }

    static void messageForBeginningOfRange() {
        System.out.println("Please enter beginning of the range: ");
    }

    static void messageForEndOfRange() {
        System.out.println("Please enter end of the range: ");
    }

    static void moreOrLessText() {
        System.out.println("\nI thinks it is: " + BinarySearchUserInput.getGuessNumber() + "\n");
        System.out.println("Please use M for More and L for less");
        System.out.println("Y - for YES!");
    }

    static void bigOResult() {
        int counter = 0;
        long rangeSize = BinarySearchUserInput.getRangeOriginal();
        while (rangeSize / 2 >= 1) {
            rangeSize = rangeSize / 2;
            counter++;
        }
        System.out.println("Your big O notation will be looks like: log" + BinarySearchUserInput.getRangeOriginal());
        System.out.println("Means for " + BinarySearchUserInput.getRangeOriginal() + " elements you will need maximum " + counter + " attempts");
    }
}
