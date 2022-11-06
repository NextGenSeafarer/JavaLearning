package lesson9.IOStreams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOex1 {

    /*

    Buffer & Channel

    Channel - двунаправленный стрим, который может и писать и читать в/из файла
    Buffer - просто место хранения

    При записи:
    Channel читает из Buffer и записывает в файл

    При чтении:
    Channel читает из файла и записывает в Buffer


    PROGRAM <----> Buffer <----> Channel <----> File

    буфер - просто место куда можно закинуть байты из file
    channel - это инструмент, который и закидывает эти байты туда
    Если инструмент может читать из файла и записывать в буфер
    Тогда он может читать из буфера и записывать в файл
    В этом есть разница между тем же FileReader и FileWriter - они оба выполняли по 1 функции, а Channel - это двунаправленный стрим

    3 ГЛАВНЫХ понятия в buffer - это POSITION - LIMIT - CAPACITY

    Capacity - объем нашего буфера и не изменяется в режиме записи и чтения
    Position - наш пойнтер, который читает или записывает байт в конкретную ячейку в данный момент
    Limit - это просто пойнтер для понимания до какой ячейки надо читать буфер после записи

    Если наш файл 12 байт, а буфер 10 байт, то будет следующее:
    Первый раз буфер запишется на 10 байт,
    Потом мы вызываем метод .flip() и начинаем читать с 0 позиции буфера
    При этом наш Limit == Capacity - 1 (потому что нумерация с 0)
    Затем мы дочитали до нашего лимита, вызываем метод .clear() - возвращаемся в 0 положение и начинаем записывать с 0 позиции
    Осталось 2 байта из 12, поэтому записываем 2 байта (нулевой и первый байт), тут же лимит становится на позиции 1
    И когда начинается чтение буфера - мы будем читать только до 1 позиции, так как лимитер на 1 позиции
    Что позволяет избежать чтения того, чего не существует





    */

    public static void main(String[] args) {

        try (RandomAccessFile file = new RandomAccessFile("test0.txt", "rw"); // создаем файлридер с возможностью чтения и записи
             FileChannel channel = file.getChannel(); // создаем канал из randomAccessFile

        ) {
            ByteBuffer buffer = ByteBuffer.allocate(10); //создаем буфер размером 10 байт


            StringBuffer sb = new StringBuffer(); // в StringBuffer будем записывать наш буфер как он будет заполняться

            int byteRead = channel.read(buffer); // читаем из канала и сразу записываем в буфер (только 10 байт)

            while (byteRead > 0) { // пока есть байты

                System.out.println("READ: " + byteRead);

                buffer.flip(); // Меняет режим буфера из режима записи в режим чтения (т.е. просто ставит пойнтер в начало буфера, чтобы начать читать)
                //К моменту вызова buffer.flip() - сам буфер уже полный, т.к. он всего на 10 байт, а файл больше, поэтому начинаем читать сверху буфера

                while (buffer.hasRemaining()) { // само чтение буфера после flip
                    sb.append((char) buffer.get()); //.get() - то же самое что и read, т.е. движемся по буферу сверху вниз и читаем каждый байт и добавляем его в SB
                }
                //как только дочитали - ставим пойнтер в начало буфера с помощью .clear() (НЕ ОЧИЩАЕМ ЕГО, А ПРОСТО ПЕРМЕЩАЕМ ПОЙНТЕР), следующие байты перезапишут существующие
                buffer.clear();
                byteRead = channel.read(buffer); //снова читаем из файла следующую порцию байт (опять же 10 байт)
            }
            // как только дочитали -
            System.out.println(sb);

            //----------- запишем в наш файл что-нибудь из другого буфера

            String additionalText = "\nIts just an additional text, which I'll add to original file!\n";
            ByteBuffer buffer2 = ByteBuffer.allocate(additionalText.getBytes().length); // создаем буфер размером нашей строки
            buffer2.put(additionalText.getBytes()); // положили в наш буфер строку
            buffer2.flip(); // вернули пойнтер в начало буфера
            channel.write(buffer2); // записали в файл с помощью channel наш 2 буфер

            // это возможно слишком сложно!! Можно сделать проще:
            String anotherString = "\n\t\t\tIT IS ANOTHER STRING FOR THE METHOD .wrap()";
            ByteBuffer buffer3 = ByteBuffer.wrap(anotherString.getBytes()); // .wrap() - сам определит размер буфера, запишет в буфер нашу строку, сделает .flip()
            channel.write(buffer3);



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
