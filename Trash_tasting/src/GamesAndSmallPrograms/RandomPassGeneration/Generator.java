package GamesAndSmallPrograms.RandomPassGeneration;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Generator {
    private static String password;
    private static ArrayList<String> passList = new ArrayList<>();

    public static ArrayList<String> getPassList() {
        return passList;
    }

    static private final Random random = new Random();

    static void letsGenerateAlphabeticSymbols() {

        for (int i = 0; i < UserInput.getLength(); i++) {
            if (UserInput.isIsDifferentCaseNeeded() && random.nextInt(0, 2) == 1) {
                char upperCaseAlphabeticSymbol = (char) random.nextInt(65, 91);
                passList.add(String.valueOf(upperCaseAlphabeticSymbol));
                continue;
            }
            char lowerCaseAlphabeticSymbol = (char) random.nextInt(97, 123);
            passList.add(String.valueOf(lowerCaseAlphabeticSymbol));
        }
        Collections.shuffle(passList);
    }

    static void letsGenerateNumbers() {
        int counter = 0;
        for (int i = 0; i < passList.size(); i++) {
            int ran = random.nextInt(0, 10);
            if (counter <= passList.size() / 3) {
                counter++;
                passList.set(random.nextInt(0, passList.size()), String.valueOf(ran));
            }
        }
        Collections.shuffle(passList);
    }

    static void letsGenerateSpecialSymbols() {
        final String[] specSymbols = {"!", "@", "#", "$", "%", "&", "_"};
        int counter = 0;
        for (int i = 0; i < passList.size(); i++) {
            if (counter <= passList.size() / 4) {
                counter++;
                passList.set(random.nextInt(0, passList.size()), specSymbols[random.nextInt(0, specSymbols.length)]);
            }
        }
        Collections.shuffle(passList);
    }

    static void showAndCheckPassword() {
        final StringBuffer sb = new StringBuffer();
        for (String s : passList) {
            sb.append(s);
        }
        if (sb.toString().toUpperCase().equals(sb.toString()) || sb.toString().toLowerCase().equals(sb.toString()) && UserInput.isIsDifferentCaseNeeded()) {
            for (int i = 0; i < sb.length(); i++) {
                String current = sb.substring(i, i + 1);
                if (i % 2 == 0) {
                    sb.replace(i, i + 1, current.toUpperCase());
                    continue;
                }
                sb.replace(i, i + 1, current.toLowerCase());
            }
        }
        password = sb.toString();
        System.out.println("Your password is: " + "\n" + password);
    }

    static void copyToClipboard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(password);
        clipboard.setContents(stringSelection, null);

    }
}
