package GamesAndSmallPrograms.RandomPassGeneration;


public class textQuestionsPassGenerator {


    private UserInput userInput = new UserInput();

    final void welcomeMessage() {
        System.out.println("""
                Welcome -userName- to RPG (Random Pass Generator)\s
                I'll try to make the best password for you""");
        System.out.println();
    }

    final void askLength() {
        System.out.println("Enter password length (optimal 6 to 12 symbols)");
        userInput.inputLength();
        System.out.println();
    }

    final void askForNumbers() {
        System.out.println("Do you want some numbers in password? (Y/N)");
        userInput.isNumbersTobeAdded();
        System.out.println();
    }

    final void askForDifferentCase() {
        System.out.println("Do you want different case of symbols in password? (Y/N)");
        userInput.isDifferentCaseNeededToBeAdded();
        System.out.println();
    }

    final void askForSpecialSymbols() {
        System.out.println("Do you want special symbols in password? (Y/N)");
        userInput.isSpecSymbolsNeededToBeAdded();
        System.out.println();
    }

    final void askForCopyToClipboard() {
        System.out.println("Do you want password to be copied to clipboard?");
        userInput.setIsCopyToClipboardNeeded();
        System.out.println();
    }
}
