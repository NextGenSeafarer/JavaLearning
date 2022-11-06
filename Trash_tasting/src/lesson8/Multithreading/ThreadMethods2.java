package lesson8.Multithreading;

public class ThreadMethods2 {

/*
    sleep

    join

    States of the Thread :


    |  new   |  ->          |  Runnable  |  ->          | Terminated |
    после создания,         ready - running,               выполнен

*/


    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Sleepy1());
        thread1.setName("SLEEPING thread ONE");
        Sleepy2 thread2 = new Sleepy2();
        thread2.setName("SLEEPING thread TWO");
        thread1.start();
        thread2.start();

        // Для того чтобы main дождался конца выполнения других потоков - есть метод join
        // метод join заставляет ждать тот поток в котором он вызван
        // т.е. thread1.join и thread2.join заставят ждать main, пока они не закончат

        thread1.join(); // вот здесь main будет ждать пока thread1 не закончит свою работу, а затем не дожидаясь
        //thread2 продолжит работу

        System.out.println("A ya ne splu(( " + Thread.currentThread().getName());


    }
}

class Sleepy1 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sorry Im sleeping " + Thread.currentThread().getName());
    }
}

class Sleepy2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sorry Im sleeping " + Thread.currentThread().getName());
    }
}