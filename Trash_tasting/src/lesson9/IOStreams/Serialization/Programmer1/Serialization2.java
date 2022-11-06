package lesson9.IOStreams.Serialization.Programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization2 {

    public static void main(String[] args) {


        Employee1 bestEmployee = new Employee1(
                "Ilia",
                "2AE",
                26,
                'm',
                3500,
                new Car(
                        "Toyota",
                        "White"));
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("bestEmp.bin"))) {

            outputStream.writeObject(bestEmployee);
            System.out.println("Your objects is created!");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
