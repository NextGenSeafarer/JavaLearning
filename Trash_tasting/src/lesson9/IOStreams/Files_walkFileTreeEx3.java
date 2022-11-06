package lesson9.IOStreams;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Files_walkFileTreeEx3 {
    public static void main(String[] args) throws IOException {


        Path toDelete = Paths.get("C:\\Users\\pocha\\Desktop\\CopyHere");


        Files.walkFileTree(toDelete, new MyFileVisitor3());
        System.out.println("DONE! ");

    }
}

class MyFileVisitor3 extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("\t\t\tFile deleted:  " + file.getFileName() + "\n");
        Files.delete(file);

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Folder deleted ->  " + dir.getFileName() + "\n");
        Files.delete(dir);

        return FileVisitResult.CONTINUE;
    }
}
