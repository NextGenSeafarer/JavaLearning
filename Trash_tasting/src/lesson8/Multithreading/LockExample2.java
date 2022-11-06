package lesson8.Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample2 {


    /*

    Пример с банкоматом, если банкомат занят, тогда все потоки ждут, один заходит, пользуется, выходит
    lock() - монитор занимается текущим потоком
    unlock() - монитор освобождается
    tryLock() - возвращает boolean, если монитор не занят - займет его, и поставит лок, если занят - будет делать все, что
    не синхронизировано в методе

    */

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        new User("Ilia", lock);
        new User("SomeUser1", lock);
        new User("SomeUser2", lock);
        new User("SomeUser3", lock);
        new User("SomeUser4", lock);


    }


}

class User extends Thread {
    String name;
    Lock lock;

    public User(String name, Lock lock) {
        this.name = name;
        this.lock = lock; // передаем в конструкторе один и тот же lock для синхронизации
        this.start(); // после вызова конструктора thread будет запущен сразу же
    }

    public void run() {
        System.out.println(name + " ждёт...");
        try {
            lock.lock();
            System.out.println(name + " пользуется банкоматом");
            Thread.sleep(1000);
            System.out.println(name + " закончил(а) пользоваться банкоматом");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

}