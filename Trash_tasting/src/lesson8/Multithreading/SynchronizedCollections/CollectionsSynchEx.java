package lesson8.Multithreading.SynchronizedCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSynchEx {

    /*

    Мы можем синхронизировать коллекции, которые изначально не синхронизированы для работы с несколькими потоками
    Для этого существует Collections.synchronizedList/Set/etc
    Ньюанс для Iterator<> -> необходимо в синхронизированном блоке прописать метод итерации по коллекции, иначе
    даже при использовании обертки может быть исключение
    Такое искусственное оборачивание синхронизированной коллекцией менее производительно чем использование спец. коллекций


    */
    public static void main(String[] args) throws InterruptedException {

        List<Integer> notSynchronizedList = new ArrayList<>(); // создаем обычный лист
        for (int i = 0; i < 1000; i++) {
            notSynchronizedList.add(i);
        }

//        Runnable runnable1 = () -> notSynchronizedList.remove(10);
//        Runnable runnable2 = () -> {
//            Iterator<Integer> iterator = notSynchronizedList.iterator();
//            while (iterator.hasNext()){
//                System.out.println(iterator.next());
//            }
//
//        };
//
//        Thread thread1= new Thread(runnable1);
//        Thread thread2= new Thread(runnable2);
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//        System.out.println(notSynchronizedList);
        // иногда выбрасывается java.util.ConcurrentModificationException
        // для избежания exception - необходимо синхронизировать наш метод

        // создадим оберткой новый синхронизированный лист

        List<Integer> synchList = Collections.synchronizedList(new ArrayList<>());
        synchList.addAll(notSynchronizedList);

        Runnable runnable1 = () -> synchList.remove(10);
        Runnable runnable2 = () -> {
            synchronized (synchList) { // синхронизируем по листу, чтобы оба треда имели доступ по очереди
                for (Integer integer : synchList) {
                    System.out.println(integer);
                }

            }
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(synchList);
        //теперь все выполняется без выбрасывания exception



    }

}
