package lesson9.IOStreams.Serialization.Programmer1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serialization1 {
    public static void main(String[] args) {

        List<String> bestProgrammers = new ArrayList<>();
        bestProgrammers.add("Ilia");
        bestProgrammers.add("UserName1");
        bestProgrammers.add("UserName2");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("bestProgrammers.bin"))) {
            outputStream.writeObject(bestProgrammers);
            System.out.println("Your object is created!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
