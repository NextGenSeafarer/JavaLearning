package lesson8.Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

import static lesson8.Multithreading.AtomicIntegerEx.ai;

public class AtomicIntegerEx {

    /*

    Атомарные классы избавляют нас от Race condition, так как позволяют работать любому множеству потоков
    синхронизировано (выполняя атомарные операции)

    */

    static AtomicInteger ai = new AtomicInteger();

    public static void main(String[] args) {
        Num num = new Num();
        Num num2 = new Num();
        num.setName(" -First Thread- ");
        num2.setName(" -Second Thread- ");
        num.start();
        num2.start();
        try {
            num.join();
            num2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

class Num extends Thread {
    public static void incrementIt() {
        ai.incrementAndGet(); // увеличивает на 1 и получает
//        ai.decrementAndGet(); // уменьшает на один и получает
//        ai.getAndIncrement(); // получает и увеличивает
//        ai.getAndDecrement(); // получает и уменьшает
//        ai.addAndGet(5); // увеличивает на 5 каждый раз
//        ai.addAndGet(-100); // уменьшает на 100 каждый раз
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            incrementIt();
            System.out.println(ai + Thread.currentThread().getName());
        }

    }

}