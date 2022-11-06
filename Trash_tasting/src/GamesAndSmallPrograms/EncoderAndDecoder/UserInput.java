package GamesAndSmallPrograms.EncoderAndDecoder;

import java.io.*;

public class UserInput {

    private static String userInput; // to keep userInput commands
    private static BufferedReader reader; // to receive from keyboard
    private static String path; // to keep a path to file
    private static boolean isOkPath; // checker for the path
    private static StringBuffer stringBuffer; // for keeping text file while encoding
    public static StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    public static void userIn() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter P - for path\nE - for encoding\nD - for decoding\nExit - for stop the program");
        while (true) {
            try {
                userInput = reader.readLine();
                if (userInput == null || userInput.matches("")) {
                    System.err.println("Input cant be empty!");
                    continue;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (userInput.matches("[EePpDd]") || userInput.matches("EXIT|Exit|exit")) {
                switch (userInput) {
                    case "p", "P" -> {
                        if (isOkPath) {
                            System.out.printf("Your path: %s", path);
                            System.err.println(" Enter next action!");
                            continue;
                        }
                        System.out.println("Enter you path: ");
                        pathChecker(); // after check for null or empty string will call File reader
                    }
                    case "e", "E" -> {
                        if (isOkPath) {
                            System.out.println("SUDA VSTAVIT encoding method");
                            System.out.println(Encoder.letsEncode(UserInput.getStringBuffer().toString()));
                            return;
                        }
                        System.err.println("Sorry, cant see your path, enter path first: ");
                        pathChecker(); // after check for null or empty string will call File reader
                        if (isOkPath) {
                            System.out.println("Path accepted!");
                            System.out.println("Enter next action!");
                        }
                        continue;
                    }
                    case "d", "D" -> {
                        if (isOkPath) {
                            System.out.println("SUDA VSTAVIT decoding method");
                            return;
                        }
                        System.err.println("Sorry, cant see your path, enter path first: ");
                        pathChecker(); // after check for null or empty string will call File reader
                        if (isOkPath) {
                            System.out.println("Path accepted!");
                            System.out.println("Enter next action!");
                        }
                        continue;
                    }
                    case "EXIT", "exit", "Exit" -> {
                        System.out.println("Exit function");
                        return;
                    }
                }
                if (isOkPath) {
                    System.out.println("Path accepted!");
                    System.out.println("Enter next action!");
                    continue;
                }
            }
            System.err.println("Not correct command!");
        }
    }

    public static void fileRead() throws IOException {
        FileReader fileReader;
        try {
            stringBuffer = new StringBuffer();
            fileReader = new FileReader(path);
            int character = 0;
            while ((character = fileReader.read()) != -1) {
                stringBuffer.append((char) character);
            }
            isOkPath = true;
        } catch (FileNotFoundException e) {
            System.err.println("Your file cannot be found!");
            path = null;
            userIn();
        }
    }

    public static void pathChecker() {
        while (true) {
            try {
                path = reader.readLine();
                if (path == null || path.matches("")) {
                    System.err.println("Not correct path!");
                    continue;
                }
                fileRead();
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
