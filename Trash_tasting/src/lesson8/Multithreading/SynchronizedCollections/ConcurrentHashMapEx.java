package lesson8.Multithreading.SynchronizedCollections;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {

    /*

    Блокировка происходит по bucket, т.е. при создании hashmap - создается стандартно 16 бакетов,
    к которым могут одновременно иметь доступ 16 тредов, т.е. блокируется отдельная ячейка, а не весь hashmap в
    целом, как бы это происходило при использовании synchronizer обертки класса Collections


    ---------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!---------------------------------------
    Единственная разница между HashMap и ConcurrentHashMap -> HashMap работает с null
                                                          ->  ConcurrentHashMap НЕ МОЖЕТ ИМЕТЬ КЛЮЧ или ЗНАЧЕНИЕ NULL
    ---------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!---------------------------------------
    */

    public static void main(String[] args) throws InterruptedException {

        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, "Ilia");
        concurrentHashMap.put(2, "Witalii");
        concurrentHashMap.put(3, "Kerill");
        concurrentHashMap.put(4, "You");
        concurrentHashMap.put(5, "Noname");

        System.out.println("ORIGINAL: " + concurrentHashMap);

        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = concurrentHashMap.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer i = iterator.next();
                System.out.println(i + " : " + concurrentHashMap.get(i));
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(3000);
                concurrentHashMap.put(6, "NEW string");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("UPDATED LIST: " + concurrentHashMap);




    }
}
