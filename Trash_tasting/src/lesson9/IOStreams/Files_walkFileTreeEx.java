package lesson9.IOStreams;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Files_walkFileTreeEx {

    public static void main(String[] args) throws IOException {

        Path myPath = Paths.get("C:\\Users\\pocha\\Desktop\\Papka A");
        Files.walkFileTree(myPath, new MyFileVisitor());


    }
}


class MyFileVisitor implements FileVisitor<Path> {

    @Override // метод, который выполняется перед заходом в директорию
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("I'm Entering folder: -> " + dir.toAbsolutePath());

        return FileVisitResult.CONTINUE;
    }

    @Override // метод, который выполняется при работе с файлами
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Checking the file: -> " + file.getFileName());

        return FileVisitResult.CONTINUE;
    }

    @Override // метод, который выполняется при сбое при доступе к файлу или папке
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Some banana happened due to unknown reason :( -> " + file.getFileName());
        return FileVisitResult.TERMINATE;
    }

    @Override // метод, который выполняется при прочтении всех файлов и папок в данном месте
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("I'm Exiting folder: -> " + dir.toAbsolutePath());

        return FileVisitResult.CONTINUE;
    }
}