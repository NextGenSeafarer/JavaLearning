package lesson9.IOStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InterfacePathEx3 {

    public static void main(String[] args) throws IOException {

        Path filePath = Paths.get("writingToFile.txt");
        if (!Files.exists(filePath)) {
            Files.createFile(filePath.resolve("writingToFile.txt"));
        }

        String someDialog = "-How is going man?\n-Same same, but different\n-Kek man, where are you going?\n" +
                "-Just planning to do some java courses, wanna with me?\n-Ok,Lets go *spanking*";
        Files.write(filePath, someDialog.getBytes());

        List<String> dialogList = Files.readAllLines(filePath);
        dialogList.forEach(System.out::println);


    }
}
