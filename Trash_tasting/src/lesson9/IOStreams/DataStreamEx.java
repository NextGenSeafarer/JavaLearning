package lesson9.IOStreams;

import java.io.*;

public class DataStreamEx {

    /*

    DataIN/OUT streams - нужны для чтения или записи примитивных типов данных

    */


    public static void main(String[] args) {

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("myTest.bin"));
             DataInputStream dataInputStream = new DataInputStream(new FileInputStream("myTest.bin"))) {


            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeShort(10);
            dataOutputStream.writeInt(100);
            dataOutputStream.writeLong(1000L);
            dataOutputStream.writeFloat(10000.1F);
            dataOutputStream.writeDouble(100000.11);

            System.out.println("Boolean : " + dataInputStream.readBoolean());
            System.out.println("Byte : " + dataInputStream.readByte());
            System.out.println("Short : " + dataInputStream.readShort());
            System.out.println("Int : " + dataInputStream.readInt());
            System.out.println("Long : " + dataInputStream.readLong());
            System.out.println("Float : " + dataInputStream.readFloat());
            System.out.println("Double : " + dataInputStream.readDouble());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
