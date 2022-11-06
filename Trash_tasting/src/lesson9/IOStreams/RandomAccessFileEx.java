package lesson9.IOStreams;

import java.io.*;

public class RandomAccessFileEx {

    /*

    Random access file нужен для того, чтобы писать и читать из любой позиции в файле


    */


    public static void main(String[] args) {

        try (
                RandomAccessFile randomAccessFile = new RandomAccessFile("test0.txt", "rw"); // w - write, r - read
        ) {


            String firstLine = randomAccessFile.readLine(); // читает до конца первой строки
            System.out.println("FIRST LINE IS: " + firstLine);
            System.out.println(randomAccessFile.getFilePointer()); // метод для просмотра места нахождения пойнтера
            String secondLine = randomAccessFile.readLine();
            System.out.println("SECOND LINE IS: " + secondLine);
            randomAccessFile.seek(randomAccessFile.length() - 1); // перемещает пойнтер в конец файла
            randomAccessFile.writeBytes("\n\t\t\t\t\tWhere is my string?? Here IT IS!");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
