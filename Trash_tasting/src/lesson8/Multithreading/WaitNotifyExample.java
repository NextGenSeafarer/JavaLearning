package lesson8.Multithreading;

public class WaitNotifyExample {

    /*

    Wait - метод применяемый для объектов имплементирующих Runnable (нитей), заставляет поток ждать, пока другая
    нить, работающая с тем же объектом не вызовет метод notify.

    */


    public static void main(String[] args) {

        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();

    }

}

class Market {
    private int breadCount = 0;


    public synchronized void getBread() {

        while (breadCount < 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount--;
        System.out.println("1 bread BOUGHT");
        System.out.println("Bread amount = " + breadCount);
        this.notify();

    }

    public synchronized void putBread() {

        while (breadCount >= 5) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount++;
        System.out.println("1 bread ADDED");
        System.out.println("Bread amount = " + breadCount);
        this.notify();
    }

}

class Producer implements Runnable {
    Market market;

    Producer(Market market) {
        this.market = market;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    Consumer(Market market) {
        this.market = market;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}


