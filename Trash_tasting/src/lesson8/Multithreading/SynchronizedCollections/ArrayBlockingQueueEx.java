package lesson8.Multithreading.SynchronizedCollections;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueEx {

    /*

    ArrayBlockingQueueEx - очередь с ограниченным размером (необходимо указывать при инициализации коллекции)

    работает с методом .add() - но выбрасывает exception (Queue full, если превышено количество элементов в очереди)
    поэтому необходимо использовать метод .offer() - который добавит элемент, если есть место, иначе не добавит

    метод .take() - возьмет 1 элемент из очереди - правило FIFO
    метод .put() - добавит элемент в очередь последним, либо будет ждать, пока не освободится место

    */


    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(4); // создаем очередь из 4 элементов


        //Producer Thread
        new Thread(() -> {
            int i = 0;
            while (i <= 50) {
                try {
                    arrayBlockingQueue.put(++i);
                    System.out.println("Producer Thread added element : " + i + "\nQueue: " + arrayBlockingQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        //Consumer Thread
        new Thread(() -> {
            while (!arrayBlockingQueue.isEmpty()) {
                try {
                    Integer j = arrayBlockingQueue.take();
                    System.out.println("Consumer Thread taken element : " + j + "\nQueue: " + arrayBlockingQueue);
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


    }


}
