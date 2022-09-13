package GamesAndSmallPrograms.RandomPassGeneration;

public class RandomPassGeneratorTest {
    public static void main(String[] args) {

        textQuestionsPassGenerator tx = new textQuestionsPassGenerator();
        tx.welcomeMessage();
        tx.askLength();
        tx.askForNumbers();
        tx.askForDifferentCase();
        tx.askForSpecialSymbols();

        Generator.letsGenerateAlphabeticSymbols();
        if (UserInput.isIsNumbersNeeded()) {
            Generator.letsGenerateNumbers();
        }
        if (UserInput.isIsSpecSymbolsNeeded()) {
            Generator.letsGenerateSpecialSymbols();
        }
        Generator.showAndCheckPassword();

        tx.askForCopyToClipboard();

        if (UserInput.isIsCopyToClipboardNeeded()) {
            Generator.copyToClipboard();
        }

    }
}
