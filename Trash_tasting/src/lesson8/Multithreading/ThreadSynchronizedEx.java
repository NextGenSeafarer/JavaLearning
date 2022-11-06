package lesson8.Multithreading;

public class ThreadSynchronizedEx {

    /*

    Data race - понятие, при котором один или другой поток может захватить определенный метод, необходимый к выполнению
    При этом результат выполнения таких методов нельзя предугадать, так как каждый раз нити будут меняться и выполнять
    методы хаотично, чем в итоге будут менять конечный результат

    ДЛЯ ИЗБЕЖАНИЯ ЭТОГО ЕСТЬ КЛЮЧЕВОЕ СЛОВО synchronized.


    Добавляя к методу ключевое слово synchronized происходит следующее:

    thread 1 -> заходит в метод increment -> ставит lock (никакие нити не могут работать с данной переменной в данный момент)
    работает с counter, изменяет её -> выходит из метода и снимает lock -> thread 2, который ждал это время выполнения
    заходит -> ставит lock -> выходит -> снимает lock

    Таким образом выполняется синхронизация потоков
    Тот, кто зайдет первым - зависит от приоритета нити и других условий
    Таким образом исходит выполнения метода increment всегда будет очевидным и правильным, независимо от количества
    нитей



    */



    public static synchronized void increment() {
        Counter.count++;
        System.out.print(Counter.count + " ");
    }

    ;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("\nMy counter is: " + Counter.count);

    }
}
class Counter {
    volatile static int count = 0;
}

class R implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3 ; i++) {
            ThreadSynchronizedEx.increment();
        }
    }
}