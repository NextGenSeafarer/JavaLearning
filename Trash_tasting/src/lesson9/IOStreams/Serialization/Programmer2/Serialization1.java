package lesson9.IOStreams.Serialization.Programmer2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Serialization1 {
    public static void main(String[] args) {

        List<String> bestProgs;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("bestProgrammers.bin"))) {
            bestProgs = (List) objectInputStream.readObject();
            System.out.println(bestProgs);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
