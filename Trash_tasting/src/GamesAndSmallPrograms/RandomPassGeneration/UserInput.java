package GamesAndSmallPrograms.RandomPassGeneration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    static private int length;
    static private boolean isNumbersNeeded;
    static private boolean isDifferentCaseNeeded;
    static private boolean isSpecSymbolsNeeded;
    static private boolean isCopyToClipboardNeeded;
    static private String userInput;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int getLength() {
        return length;
    }

    public static boolean isIsNumbersNeeded() {
        return isNumbersNeeded;
    }

    public static boolean isIsDifferentCaseNeeded() {
        return isDifferentCaseNeeded;
    }

    public static boolean isIsSpecSymbolsNeeded() {
        return isSpecSymbolsNeeded;
    }

    public static boolean isIsCopyToClipboardNeeded() {
        return isCopyToClipboardNeeded;
    }

    void inputLength() {
        try {
            while (true) {
                if ((userInput = reader
                        .readLine())
                        .replaceAll("\\d", "")
                        .strip()
                        .length() > 0) {
                    System.err.println("Numbers accepted only");
                    continue;
                }
                String userLength = userInput.replaceAll("\\s", "");
                if (userInput.equals("")) {
                    System.err.println("Cannot be blank");
                    continue;
                }
                if (Integer.parseInt(userLength) > 128) {
                    System.err.println("I don't think that any site will accept such\nbig pass, try again");
                    continue;
                }
                if (Integer.parseInt(userLength) <= 3) {
                    System.err.println("Short password might be easy to hack, please choose longer");
                    continue;
                }
                length = Integer.parseInt(userLength);
                break;
            }
            System.out.println("Password length: " + length);
        } catch (IOException e) {
            System.out.println("Some unexpected error!");
            throw new RuntimeException(e);
        }
    }

    void isNumbersTobeAdded() {
        while (true) {
            try {
                userInput = reader.readLine();
                if (userInput.equals("")) {
                    System.err.println("Cannot be blank");
                    continue;
                }
                if (userInput.replaceAll("[YNyn]", "").length() > 0) {
                    System.err.println("Please enter Y or N");
                    continue;
                }
                if (userInput.equals("Y") || userInput.equals("y")) {
                    System.out.println("Numbers will be added to the password");
                    isNumbersNeeded = true;
                    break;
                }
                System.out.println("No numbers will be added to the password");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void isDifferentCaseNeededToBeAdded() {
        while (true) {
            try {
                userInput = reader.readLine();
                if (userInput.equals("")) {
                    System.err.println("Cannot be blank");
                    continue;
                }
                if (userInput.replaceAll("[YNyn]", "").length() > 0) {
                    System.err.println("Please enter Y or N");
                    continue;
                }
                if (userInput.equals("Y") || userInput.equals("y")) {
                    System.out.println("Upper and Lower case symbols will be added to the password");
                    isDifferentCaseNeeded = true;
                    break;
                }
                System.out.println("Only lower case symbols will be added to the password");
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void isSpecSymbolsNeededToBeAdded() {
        while (true) {
            try {
                userInput = reader.readLine();
                if (userInput.equals("")) {
                    System.err.println("Cannot be blank");
                    continue;
                }
                if (userInput.replaceAll("[YNyn]", "").length() > 0) {
                    System.err.println("Please enter Y or N");
                    continue;
                }
                if (userInput.equals("Y") || userInput.equals("y")) {
                    System.out.println("Special symbols will be added to the password");
                    isSpecSymbolsNeeded = true;
                    break;
                }
                System.out.println("No special symbols will be added to the password");
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void setIsCopyToClipboardNeeded() {
        while (true) {
            try {
                userInput = reader.readLine();
                if (userInput.equals("")) {
                    System.err.println("Cannot be blank");
                    continue;
                }
                if (userInput.replaceAll("[YNyn]", "").length() > 0) {
                    System.err.println("Please enter Y or N");
                    continue;
                }
                if (userInput.equals("Y") || userInput.equals("y")) {
                    System.out.println("Copied!");
                    isCopyToClipboardNeeded = true;
                    break;
                }
                System.out.println("No copy means no copy so.. ");
                break;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
