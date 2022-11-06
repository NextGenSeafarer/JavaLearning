package lesson8.Multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
/*

CountDownLatch - синхронизатор, который разрешит запустить треды как только счетчик станет 0

Методы:
.countDown() - уменьшает счетчик на единицу
.getCount() - возвращает текущий таймер
.await() - замораживает тред до момента счётчик -> 0


*/

    static CountDownLatch falconTimer = new CountDownLatch(3);

    public static void areaIsClear() {
        try {
            Thread.sleep(1000);
            System.out.println("Area for start FALCON's is ready!");
            falconTimer.countDown();
            System.out.println("Timer is: " + falconTimer.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void engineChecked() {
        try {
            Thread.sleep(1000);
            System.out.println("Engines of FALCON's are ready!");
            falconTimer.countDown();
            System.out.println("Timer is: " + falconTimer.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void allReadyStart() {
        try {
            Thread.sleep(1000);
            System.out.println("Start the FALCON!");
            falconTimer.countDown();
            System.out.println("Timer is: " + falconTimer.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        new Falcon7("7", falconTimer);
        new Falcon7("8", falconTimer);
        new Falcon7("9", falconTimer);
        new Falcon7("10", falconTimer);

        areaIsClear();
        engineChecked();
        allReadyStart();


    }
}

class Falcon7 extends Thread {
    private String name;
    private CountDownLatch countDownLatch;

    public Falcon7(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.printf("FALCON %s is up to the sky\n", name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
