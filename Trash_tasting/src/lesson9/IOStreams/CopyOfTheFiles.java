package lesson9.IOStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyOfTheFiles {


    /*

    File Input Stream - нужен для чтения файлов (бинарных, картинок и тд)
    File Output Stream - нужен для записи куда - либо

    */

    public static void main(String[] args) {

        try (FileInputStream inputStream = new FileInputStream(
                "E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\src\\lesson9\\IOStreams\\FilesFolder\\IMG_3188.PNG");
             FileOutputStream fileOutputStream = new FileOutputStream(
                     "E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\src\\lesson9\\IOStreams\\FilesFolder\\Copied.PNG")) {
            double start = System.currentTimeMillis();

            int i;
            while ((i = inputStream.read()) != -1) {
                fileOutputStream.write(i);
            }
            double finish = System.currentTimeMillis();
            System.out.printf("Time spend: %f ms", finish - start);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
