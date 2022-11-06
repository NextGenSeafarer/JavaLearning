package lesson9.IOStreams;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {

    /*

        FileWriter - стрим для записи в файл по символьно
        существует 2 пути для конструктора FileWriter - абсолютный и относительный
        Абсолютный: E:\02.Java_projects\Testing_garbage\Trash_tasting\src\lesson9\IOStreams\FilesFolder\ex1.txt
        Относительный (относительно проекта, т.е. просто название файла)

        FileReader - стрим для чтения файла

        Оба стрима необходимо закрывать!


    */
    public static void main(String[] args) throws IOException, InterruptedException {

        String text = "Я учу Java уже 5 месяцев\n" +
                "Но все больше начинаю понимать\n" +
                "Что ничего не понимаю";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\src\\lesson9\\IOStreams\\FilesFolder\\ex1.txt", true);
            //если в конструктор добавить 2 параметр true, то текст в файле будет не перезаписываться, а добавляться к существующему
            fileWriter.write(text);
            fileWriter.write("\nКак бы мне так научиться Java.. хм..");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fileWriter.close();
        }
        System.out.println("Its done! Check the file!\nAnd now we are getting it to the console..");

        Thread.sleep(3000);

        FileReader fileReader = null;
        fileReader = new FileReader("E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\src\\lesson9\\IOStreams\\FilesFolder\\ex1.txt");
        int character;
        while ((character = fileReader.read()) != -1) {
            System.out.print((char) character);
        }
        System.out.println("\nWow! Its ready also) ");
        fileReader.close();


    }
}
