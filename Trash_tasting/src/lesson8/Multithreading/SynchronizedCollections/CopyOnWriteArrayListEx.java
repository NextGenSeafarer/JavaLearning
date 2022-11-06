package lesson8.Multithreading.SynchronizedCollections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListEx {

    /*

    Работа CopyOnWriteArrayList производится на копиях исходного листа (каждый раз потоком при изменении создается новая копия)
    Т.е. такая коллекция будет не производительна при многих операциях изменения элементов
    Зато подойдет при множественном чтении элементов




    */

    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("Privet");
        copyOnWriteArrayList.add("Poka");
        copyOnWriteArrayList.add("Kaef");
        copyOnWriteArrayList.add("Ola");


        System.out.println("ORIGINAL LIST : " + copyOnWriteArrayList);


        Runnable runnable1 = () -> {
            Iterator<String> iterator = copyOnWriteArrayList.iterator();
            System.out.println("\nI'm " + Thread.currentThread().getName() + " just started iteration of the original List\n");
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(1000);
                    System.out.println(iterator.next());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable runnable2 = () -> {
            System.out.println("\nI'm " + Thread.currentThread().getName() + " created new copy of the List and replace Kaef\n");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            copyOnWriteArrayList.remove("Kaef");
            copyOnWriteArrayList.add("I learn java multithreading");
        };




        Thread thread1 = new Thread(runnable1);
        thread1.setName("Thread 1 ");
        Thread thread2 = new Thread(runnable2);
        thread2.setName("Thread 2 ");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("\nUPDATED LIST : " + copyOnWriteArrayList);


    }


}
