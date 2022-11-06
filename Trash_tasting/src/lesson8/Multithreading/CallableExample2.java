package lesson8.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample2 {

    /*

    В этом примере будет подсчет числе от 0 до 1 млр с помощью executorService и интерфейса Callable

    */

    private static long sum = 0;
    private static final long value = 1_000_000_000L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10); // создаем тред пул
        List<Future<Long>> futureResults = new ArrayList<>(); // лист для хранения наших промежуточных результатов выполнения тасков

        long dev = value / 10;
        for (int i = 0; i < 10; i++) { // просто логика работы разделения потоков
            long from = dev * i + 1;
            long to = dev * (i + 1);
            CalcTheSum calcTheSum = new CalcTheSum(from, to); // в конструкторе передаем параметры от и до какой цифры считать сумму
            Future<Long> localRes = executorService.submit(calcTheSum); // т.е CalcTheSum возвращает нам Long, то мы записываем результат в Future<Long>
            futureResults.add(localRes); // добавляем в лист с Future
        }

        for (Future<Long> future : futureResults) {
            sum += future.get(); //используем метод .get() чтобы получить значение из future класса
        }
        executorService.shutdown();
        System.out.printf("Result is : %d", sum);


    }

}

class CalcTheSum implements Callable<Long> {

    private long from;
    private long to;
    private long currentSum;

    public CalcTheSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        for (long i = from; i <= to; i++) {
            currentSum += i;
        }
        System.out.printf("Current result of summing from %d to %d is %d\n", from, to, currentSum);

        return currentSum;
    }
}
