package lesson9.IOStreams;

import java.io.*;

public class CopyOfTheFiles2_Buffered {

    public static void main(String[] args) {

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(
                "E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\src\\lesson9\\IOStreams\\FilesFolder\\IMG_3188.PNG"));
             BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(
                     "E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\src\\lesson9\\IOStreams\\FilesFolder\\Copied2.PNG"))) {

            double start = System.currentTimeMillis();
            int st;
            while ((st = inputStream.read()) != -1) {
                fileOutputStream.write(st);
            }
            double finish = System.currentTimeMillis();
            System.out.printf("Time spend: %f ms\n", finish - start);
            System.out.println("Almost x100 times faster than without buffering");




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

