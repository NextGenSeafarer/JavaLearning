package lesson9.IOStreams;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileExample2 {
    public static void main(String[] args) {


        File folder = new File("E:\\01.MyTestFolder");

        System.out.println("Is directory? " + folder.isDirectory());


        List<File> listOfFoldersOfDiskE = new ArrayList<>(Arrays.asList(folder.listFiles()));
        listOfFoldersOfDiskE.stream().forEach(x -> {
            x.renameTo(new File(x.toString().toLowerCase()));
        });
//        listOfFoldersOfDiskE.stream().forEach(x -> {
//            if (x.toString().contains("-")) {
//                x.delete();
//            }
//        });


        long diskLen = listOfFoldersOfDiskE.stream().map(File::length).reduce(Long::sum).get();
        double diskLenInMb = diskLen / (1024 * 1024D);
        System.out.printf("All files : %d bytes -> %f mb\n", diskLen, diskLenInMb);

        listOfFoldersOfDiskE.stream().sorted(File::compareTo).forEach(System.out::println);
        //System.out.println("folder is created: " + new File("E:\\01.MyTestFolder\\bones").mkdir());


    }
}
