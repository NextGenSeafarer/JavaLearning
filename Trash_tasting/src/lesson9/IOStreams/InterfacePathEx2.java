package lesson9.IOStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class InterfacePathEx2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path movable = Paths.get("movablePart.txt");
        if (!Files.exists(movable)) {
            Files.createFile(movable);

        }

        Path filePath = Paths.get("fileForPathTesting.txt");
        Path directoryPath = Paths.get("E:\\01.MyTestFolder\\folder");
        Path directoryPath2 = Paths.get("E:\\01.MyTestFolder\\folder\\kek");


        //Files.copy(filePath, directoryPath.resolve(filePath));

        Files.copy(filePath, directoryPath.resolve("AnotherTest.txt"), StandardCopyOption.REPLACE_EXISTING);
        // можно копировать с любым именем, второй параметр разрешает перезапись
        System.out.println("done!");
        if (!Files.exists(directoryPath2)) {
            Files.createDirectory(directoryPath2);
            Files.copy(directoryPath, directoryPath2.resolve("MY_NAME_IS_HIZENBERG"));
        }


        //Files.move(movable, directoryPath.resolve(movable), StandardCopyOption.REPLACE_EXISTING);

        //с помощью move можно переименовывать файлы

        Path movable2 = Paths.get("movablePart0.txt");
        if (!Files.exists(movable2)) {
            Files.createFile(movable2);

        }

        for (int i = 0; i < 5000; i++) {
            Files.move(Paths.get("movablePart" + i + ".txt"), Paths.get("movablePart" + (i + 1) + ".txt"),StandardCopyOption.REPLACE_EXISTING);
        }

        Path deleteFile = Paths.get("fileForDelete");
        if (!Files.exists(deleteFile)) {
            Files.createFile(deleteFile);
        }
        //Files.delete(deleteFile);


    }
}
