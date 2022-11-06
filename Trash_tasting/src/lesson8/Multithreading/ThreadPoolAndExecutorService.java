package lesson8.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolAndExecutorService {

    /*

    ExecutorService - интерфейс для создания пула тредов, создание происходит за счет фабричного метода
    Executors.newFixedThreadPool() - для создания любого количества потоков,
    Executors.newSingleThreadExecutor() - для создания строго одного потока

    Как это работает:
                 ________________
    TASK 1 ->   |               |     ExecutorService executorService = Executors.newFixedThreadPool(5);
    TASK 2 ->   |   ThreadPool  |       тред пул содержит в себе наши треды, если есть свободные треды - они будут брать задачи
    TASK 3 ->   |               |           которые поставляются методом .execute()
                ----------------
    После создания ThreadPool - он будет ожидать бесконечно других задач, если даже все выполнены, поэтому его необходимо закрывать
    через метод .shutdown(), по аналогии с .join() - ожидать завершения executorService - .awaitTermination()




    */


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starts!");
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableEx3());
        }
        executorService.shutdown(); // необходим для завершения executor service, иначе он будет ждать дальнейших заданий
        executorService.awaitTermination(5, TimeUnit.SECONDS); // аналогия метода .join(), во втором параметре можно указать он наносекунд до дней
        System.out.println("Main finish!");


    }
}

class RunnableEx3 implements Runnable {
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
