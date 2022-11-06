package lesson9.IOStreams.Serialization.Programmer2;

import lesson9.IOStreams.Serialization.Programmer1.Employee1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Serialization2 {

    public static void main(String[] args) {

        Employee1 bestEmployee;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("bestEmp.bin"))) {

            bestEmployee = (Employee1) objectInputStream.readObject();
            System.out.println(bestEmployee);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
