package lesson9.IOStreams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesEx {

    /*
    Если в try указаны ресурсы - тогда закрывать в блоке finally поток необязательно

    */
    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\src\\lesson9\\IOStreams\\FilesFolder\\ex2.txt");
             FileWriter fileWriter = new FileWriter("E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\src\\lesson9\\IOStreams\\FilesFolder\\ex2.txt",true);
        ) {
            fileWriter.write("\nMy additional STRING!");
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
