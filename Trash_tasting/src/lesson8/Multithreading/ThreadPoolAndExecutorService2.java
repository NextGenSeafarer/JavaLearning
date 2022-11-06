package lesson8.Multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolAndExecutorService2 {

    /*

    ScheduledExecutorService
    Существует несколько методов, которые различаются в периодах между выполнением метода execute()
    А именно метод .schedule() - начнет выполнение тасков через фиксированное время
                   .scheduleAtFixedRate() - начнет выполнение тасков через фиксированное время с периодом между НАЧАЛОМ каждого таска в заданное время
                                            ***Если время выполнения дольше чем указанный параметр - то выполнение следующего начнется сразу
                            Время выполнения: 1 секунда
                                            |task1          ||task2          ||task3          |
                        Время между тасками:  0.5 секунд   -> начнет выполнение сразу же

                   .scheduleWithFixedDelay() - начнет выполнение тасков через фиксированное время с периодом между КОНЦОМ каждого таска в заданное время;
                             Время выполнения: 1 секунда
                                            |task1          ||task2          ||task3          |
                        Время между тасками:  0.5 секунд   -> после выполнения task1 будет ждать 0.5 секунд и приступит к task2


    */

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main starts\n");
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1); //создаем пул с 1 тредом
        System.out.println("executorService with method schedule() start\n");
        executorService.schedule(new RunnableEx4(), 1, TimeUnit.SECONDS); // начнет работу через 3 секунды
        Thread.sleep(5000);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("executorService with method schedule() finish\n");

        ScheduledExecutorService executorService2 = Executors.newScheduledThreadPool(1); //создаем пул с 1 тредом
        System.out.println("executorService with method scheduleAtFixedRate() start\nDelay is: 2 seconds between START OF 1st TASK AND START OF 2nd TASK\n" +
                "TASK TIME IS 1 SECOND, MEANS BETWEEN 2 TASKS IS 1 SECOND DELAY");
        executorService2.scheduleAtFixedRate(new RunnableEx4(), 15, 2, TimeUnit.SECONDS); // начнет работу через 15 секунд и будет выполнять работу через 2 секунды
        Thread.sleep(25000);

        executorService2.shutdown();
        executorService2.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("executorService with method scheduleAtFixedRate() finish\n");


        ScheduledExecutorService executorService3 = Executors.newScheduledThreadPool(1);
        System.out.println("executorService with method scheduleWithFixedDelay() start\nDelay is: 4 seconds between END OF 1st TASK AND START OF 2nd TASK\n" +
                "TASK TIME IS DOESN'T MATTER, TIME BETWEEN 2 TASKS IS 4 SECONDS DELAY");
        executorService3.scheduleWithFixedDelay(new RunnableEx4(), 15, 4, TimeUnit.SECONDS);
        Thread.sleep(35000);
        executorService3.shutdown();
        executorService3.awaitTermination(3,TimeUnit.SECONDS);
        System.out.println("executorService with method scheduleWithFixedDelay() finish\n");


    }
}

class RunnableEx4 implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins to work");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " ends with work");
    }
}

