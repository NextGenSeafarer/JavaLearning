package lesson9.IOStreams;

import java.io.*;

public class BufferedReader_Writer {

/*

BufferedReader & BufferedWriter - это обертки FileReader & FileWriter соответственно
Добавляют доп функциональность (буферизацию) для стримов чтения или записи
Основная разница - буферизованные стримы позволяют обращаться к файлу намного меньше раз чем обычный Reader/Writer
(которые записывают/читают информацию посимвольно) вследствие чего повышается производительность

*/


    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader
                ("E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\src\\lesson9\\IOStreams\\FilesFolder\\ex2.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter
                     ("E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\src\\lesson9\\IOStreams\\FilesFolder\\ex3.txt"))){
            String line;
            while ((line = bufferedReader.readLine())!=null){
                bufferedWriter.write(line);
            }
            System.out.println("Its done!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
