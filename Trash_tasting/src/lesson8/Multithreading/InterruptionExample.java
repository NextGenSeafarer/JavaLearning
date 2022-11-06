package lesson8.Multithreading;

import java.util.ArrayList;
import java.util.List;

public class InterruptionExample {

    /*

    В более ранних версиях JDK потоки прерывались методом stop()
    НО так как состояние объектов после столь грубого прерывания оставались в неясном состоянии -
    данный метод был удален и заменен interrupted()
    Сам метод не прерывает поток, он только посылает сигнал потоку, что его хотят прервать, проверить данный сигнал
    можно методом isInterrupted(), который возвращает булеву переменную, а что делать при этом решает уже сам программист


    */

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main is started!");
        InterruptMe interruptMe = new InterruptMe();
        interruptMe.setName("Calculation");
        interruptMe.start();
        Thread.sleep(3000);

        System.out.println("Main is interrupting our thread!");
        interruptMe.interrupt();
        interruptMe.join();
        System.out.println("\nMain is finished!");


    }


}

class InterruptMe extends Thread {
    public void run() {
        List<Double> list = new ArrayList<>();
        double sum = 0;
        System.err.println(currentThread().getName() + " thread is saying :" + " I start to work");
        for (int i = 0; i < 1000000000; i++) {
            if (isInterrupted()) {
                System.out.println("\n" + currentThread().getName() + " thread is saying :" + "\nFOR THAT PERIOD OF TIME I HAVE FOUND THAT SUM: " + sum
                        + "\nI don't really understand why always during work someone interrupt me!");
                return;
            }
            sum += Math.sqrt(i);
            list.add(sum);
            // если же сюда добавить метод sleep() - тогда нужно было бы в try/catch описывать действия потока при его прерывании во время сна!
        }
    }
}
