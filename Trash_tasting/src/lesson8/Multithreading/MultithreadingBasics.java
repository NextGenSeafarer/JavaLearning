package lesson8.Multithreading;

public class MultithreadingBasics {

    /*

        Основные цели multithreading :
        - ускорение работы
        - параллельная работа (Concurrency)

        context switch - реализация многопоточности на 1 ядре (будет медленнее чем последовательное выполнение), т.к.
        будет затрачено дополнительное время на переключение между задачами
        работа с задачей 1 -> работа с задачей 2 -> работа с задачей 3 -> работа с задачей 2 и тд

    */
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

        //ещё варианты создания через анонимный класс и лямбда выражения:

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("HELLO WORLD !");
            }
        }).start();

        new Thread(() -> System.out.println("HELLO WORLD 2 !")).start();



    }




}

class MyThread1 extends Thread {
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println("SECOND THREAD " + i);
        }
    }
}

class MyThread2 extends Thread {
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}
