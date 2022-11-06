package lesson9.IOStreams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOex2 {

    /*


    buffer.clear() - возвращается в начало буфера и начинает перезаписывать с нулевого элемента
    buffer.rewind() - возвращается в начало буфера и начинает читать тот же самый буфер с начала

    buffer.flip() - возвращается в начало и начинает читать (нужен для работы вместе с .clear())

    buffer.compact() - записывает непрочитанные байты в начало, начинает писать с первой освободившейся ячейки
    необходим, когда нужно что - то записать в буфер и не потерять информацию из непрочитанных байтов (они перезапишутся в начало)

    buffer.mark() - отмечает текущую позицию пойнтера
    buffer.reset() - возвращает пойнтер в позицию, сохраненную .mark()


    */


    public static void main(String[] args) {



        try (RandomAccessFile file = new RandomAccessFile("test100.txt", "r");
             FileChannel channel = file.getChannel();
        ) {

            ByteBuffer buffer = ByteBuffer.allocate(5); //создаем буфер с вместительностью 5
            System.out.println("-------------------Размер буфера: 5---------------\n");
            channel.read(buffer);
            buffer.flip();
            System.out.println("-------------------Читаем первые 3 записанных элемента---------------");
            System.out.println("1st buffer.get() == " + (char) buffer.get());
            System.out.println("2nd buffer.get() == " + (char) buffer.get());
            System.out.println("3rd buffer.get() == " + (char) buffer.get());

            /*

            По идее можно вернуться к началу буфера с помощью метода .clear(), который поместит пойнтер в начало буфера
            Но при этом все байты будут перезаписаны если будет запись на них (при очередном чтении - ничего не произойдет)

            buffer.clear();
            System.out.println("-------------------AFTER .clear()---------------");
            System.out.println("1st buffer.get() == " + (char)buffer.get());
            System.out.println("2nd buffer.get() == " + (char)buffer.get());
            System.out.println("3rd buffer.get() == " + (char)buffer.get());
            System.out.println("4th buffer.get() == " + (char)buffer.get());
            System.out.println("5th buffer.get() == " + (char)buffer.get());

            */

            //Но лучше использовать метод .rewind() - который вернет пойнтер в начало также
            buffer.rewind();
            System.out.println("-------------------AFTER .rewind()---------------");
            System.out.println("1st buffer.get() == " + (char) buffer.get());
            System.out.println("2nd buffer.get() == " + (char) buffer.get());
            System.out.println("3rd buffer.get() == " + (char) buffer.get());
            System.out.println("--------------------непрочитанные элементы в буфере: 4, 5------------------------");

            buffer.compact(); // перезапишет оставшиеся непрочитанными элементы в начало буфера
            channel.read(buffer);
            buffer.rewind();
            System.out.println("-------------------AFTER .compact()---------------");
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            buffer.clear(); // возвращаемся в начало
            channel.read(buffer);
            buffer.rewind();
            System.out.println("1st buffer.get() == " + (char) buffer.get());
            System.out.println("2nd buffer.get() == " + (char) buffer.get());
            buffer.mark();
            System.out.println("-------------------.mark() on symbol \"b\"---------------");
            while (buffer.hasRemaining()) {
                System.out.println("buffer.get() == " + (char) buffer.get());
            }

            buffer.reset();
            System.out.println("-------------------AFTER .reset() started again from \"b\"---------------");
            while (buffer.hasRemaining()) {
                System.out.println("buffer.get() == " + (char) buffer.get());
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
