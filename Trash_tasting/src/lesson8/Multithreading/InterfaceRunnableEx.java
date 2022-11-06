package lesson8.Multithreading;

public class InterfaceRunnableEx {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyThread3());
        Thread thread2 = new Thread(new MyThread4());
        thread1.start();
        thread2.start();

    }

}

class MyThread3 implements Runnable {

    @Override
    public void run() {
        System.out.println("IM ALIVE! 1");
    }
}

class MyThread4 implements Runnable {

    @Override
    public void run() {
        System.out.println("IM ALIVE! 2");
    }
}
