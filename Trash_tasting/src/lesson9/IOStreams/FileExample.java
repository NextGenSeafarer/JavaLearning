package lesson9.IOStreams;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Arrays;

public class FileExample {

/*

Класс File нужен для работы с файлами и директориями все основные методы:

.getAbsolutePath() - получить абсолютный путь до файла
.isAbsolute() - булева переменная, проверяет путь на его абсолютность
.isDirectory() - булева переменная, проверяет переданный путь, является ли папкой
.exists() - булева переменная, проверяет на существование папки/файла
.createNewFile() - создает новый файл
.mkdir() - make directory, создает папку
.length() - возвращает в байтах вес файла
.delete() - удаляет файлы или папки (только если папка пустая)
.listFiles() - возвращает массив содержимого папки
.isHidden() - булева переменная, проверяет скрыт ли файл/папка
.canRead() - булева переменная, проверяет можно ли читать файл/папку
.canWrite() - булева переменная, проверяет можно ли писать в файл/папку
.canExecute() - булева переменная, проверяет можно ли выполнить файл
.lastModified() - время последнего изменения
.getName() - возвращает имя файла / папки
.setReadOnly() - запрещает изменение файла и делает его readOnly
.renameTo() - переименовывает файл

*/

    public static void main(String[] args) throws IOException {

        File file = new File("myTest.bin"); // относительный путь до файла в этом проекте
        File folder = new File("E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\src\\lesson9\\IOStreams"); // абсолютный путь до папки
        File notExistedFile = new File("NotExist.kek");
        File notExistedFolder = new File("E:\\NotExistedFolderLOL");

        System.out.println("getAbsolutePath() file --> " + file.getAbsolutePath());
        System.out.println("getAbsolutePath() folder --> " + folder.getAbsolutePath());
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("isAbsolute() file --> " + file.isAbsolute());
        System.out.println("isAbsolute() folder --> " + folder.isAbsolute());
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("isDirectory() file --> " + file.isDirectory());
        System.out.println("isDirectory() folder --> " + folder.isDirectory());
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("exists() notExistedFile --> " + notExistedFile.exists());
        System.out.println("exists() notExistedFolder --> " + notExistedFolder.exists());
        System.out.println("exists() file --> " + file.exists());
        System.out.println("exists() folder --> " + folder.exists());
        System.out.println("-------------------------------------------------------------------------------------");


        System.out.println("createNewFile() notExistedFile --> " + notExistedFile.createNewFile());
        System.out.println("mkdir() notExistedFolder --> " + notExistedFolder.mkdir());
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("length() file --> " + file.length());
        System.out.println("length() folder --> " + folder.length());
        System.out.println("-------------------------------------------------------------------------------------");


        System.out.println("delete() notExistedFile --> " + notExistedFile.delete());
        System.out.println("delete() notExistedFolder --> " + notExistedFolder.delete());
        System.out.println("-------------------------------------------------------------------------------------");


        System.out.println("listFiles() folder --> " + Arrays.toString(folder.listFiles()));
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("isHidden() file --> " + file.isHidden());
        System.out.println("canRead() file --> " + file.canRead());
        System.out.println("canWrite() file --> " + file.canWrite());
        System.out.println("canExecute() file --> " + file.canExecute());
        System.out.println("-------------------------------------------------------------------------------------");

        Time time = new Time(file.lastModified());
        System.out.println("lastModified() file --> " + time);
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("getName() file --> " + file.getName());
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("setReadOnly() file --> " + file.setReadOnly());
        System.out.println("-------------------------------------------------------------------------------------");

//        System.out.println("renameTo() file --> " + file.renameTo(new File("myTest.bin")));
//        System.out.println("-------------------------------------------------------------------------------------");

    }
}
