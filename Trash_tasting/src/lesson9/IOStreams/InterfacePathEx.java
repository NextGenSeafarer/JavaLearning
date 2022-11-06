package lesson9.IOStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class InterfacePathEx {
    public static void main(String[] args) throws IOException {

        Path filePath = Paths.get("fileForPathTesting.txt");
        Path directoryPath = Paths.get("E:\\01.MyTestFolder\\folder");

        System.out.println("filePath.getFileName() -> " + filePath.getFileName());
        System.out.println("directoryPath.getFileName() -> " + directoryPath.getFileName());
        System.out.println("--------------------------------------------------------\n");

        System.out.println("filePath.getParent() -> " + filePath.getParent()); // возвращает абсолютный путь до папки (до места где есть сама папка или файл)
        System.out.println("directoryPath.getParent() -> " + directoryPath.getParent());
        System.out.println("--------------------------------------------------------\n");

        System.out.println("filePath.getRoot() -> " + filePath.getRoot());
        System.out.println("directoryPath.getRoot() -> " + directoryPath.getRoot());
        System.out.println("--------------------------------------------------------\n");

        System.out.println("filePath.isAbsolute() -> " + filePath.isAbsolute());
        System.out.println("directoryPath.isAbsolute() -> " + directoryPath.isAbsolute());
        System.out.println("--------------------------------------------------------\n");

        System.out.println("filePath.toAbsolutePath() -> " + filePath.toAbsolutePath());
        System.out.println("directoryPath.toAbsolutePath() -> " + directoryPath.toAbsolutePath());
        System.out.println("--------------------------------------------------------\n");

        System.out.println("filePath.toAbsolutePath().getParent() -> " + filePath.toAbsolutePath().getParent());
        System.out.println("directoryPath.toAbsolutePath().getRoot() -> " + directoryPath.toAbsolutePath().getRoot());
        System.out.println("--------------------------------------------------------\n");


        System.out.println("directoryPath.resolve(filePath) -> " + directoryPath.resolve(filePath)); // просто объединяет пути папки и файла
        // подойдет для того, чтобы перемещать файлы в папку
        System.out.println("--------------------------------------------------------\n");


        Path anotherPath = Paths.get("E:\\01.MyTestFolder\\folder\\A\\B\\C\\test.txt");
        System.out.println("directoryPath.relativize(anotherPath) -> " + directoryPath.relativize(anotherPath));
        // грубо говоря относительный путь, т.е. разница между одним путем и вторым


        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
            System.out.println("File is created!");
        }

        if(!Files.exists(directoryPath)){
            Files.createDirectory(directoryPath);
            System.out.println("Directory is created!");
        }

        System.out.println("Files.isReadable(filePath) -> " + Files.isReadable(filePath));
        System.out.println("Files.isWritable(filePath) -> " + Files.isWritable(filePath));
        System.out.println("Files.isExecutable(filePath) -> " + Files.isExecutable(filePath));
        System.out.println("--------------------------------------------------------\n");

        Path filePath2 = Paths.get("E:\\02.Java_projects\\Testing_garbage\\Trash_tasting\\fileForPathTesting.txt");
        System.out.println("Files.isSameFile(filePath2,filePath) -> " + Files.isSameFile(filePath2,filePath));
        // сравниваем являются ли файлы одинаковыми, если передать абсолютный и относительный путь
        System.out.println("--------------------------------------------------------\n");

        System.out.println("Files.size(filePath) " + Files.size(filePath) + " bytes");
        System.out.println("--------------------------------------------------------\n");

        System.out.println("Get creationTime: " + Files.getAttribute(filePath, "creationTime"));
        System.out.println("--------------------------------------------------------\n");
        Map<String, Object> mapAttributes = Files.readAttributes(filePath, "*");
        System.out.println("Files.readAttributes возвращает Map <String, Object>");
        for(Map.Entry<String, Object> entry : mapAttributes.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


    }


}
