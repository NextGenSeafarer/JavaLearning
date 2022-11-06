package lesson9.IOStreams;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Files_walkFileTreeEx2 {
    public static void main(String[] args) throws IOException {

        Path pathSource = Paths.get("C:\\Users\\pocha\\Desktop\\Papka A");
        Path pathDestination = Paths.get("C:\\Users\\pocha\\Desktop\\CopyHere");
        if (!Files.exists(pathDestination)) {
            Files.createDirectory(pathDestination);
        }
        Files.walkFileTree(pathSource, new MyFileVisitor2(pathSource, pathDestination));

    }
}

class MyFileVisitor2 extends SimpleFileVisitor<Path> {
    Path source;
    Path destination;

    public MyFileVisitor2(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(source.relativize(dir));
        Files.copy(dir, newDestination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Folder -> " + dir.getFileName() + " copied!\n");

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(source.relativize(file));
        Files.copy(file, newDestination);
        System.out.println("File -> " + file.getFileName() + " copied!\n");

        return FileVisitResult.CONTINUE;
    }
}
