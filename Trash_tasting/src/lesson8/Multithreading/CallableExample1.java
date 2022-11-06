package lesson8.Multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class CallableExample1 {

    /*

    Callable так же как и Runnable может быть использован для передачи в executor service задач
    Разница между callable и runnable в том, что метод .call() объекта типа Callable может возвращать объект (Runnable
    return type is void), а также выбрасывать exceptions, что опять же runnable не может делать

    Использовать awaitTermination не нужно, так как при использовании метода .get() у объекта Future - поток будет
    заморожен пока не выполнится таск (ибо без выполнения таска получить объект класса Future невозможно)

    */

    static int factorialResults;


    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Enter factorial of which number you want: ");
        try {
            CallableFactorial callableFactorial = new CallableFactorial(Integer.parseInt(reader.readLine()));
            Future<Integer> future = executorService.submit(callableFactorial);
            factorialResults = future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getCause());
            return;
        } catch (IOException ignored) {
        } finally {
            executorService.shutdown();
        }
        System.out.printf("Your factorial is : %d", factorialResults);


    }
}

class CallableFactorial implements Callable<Integer> {

    int f;

    public CallableFactorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f <= 0) {
            throw new Exception("Input is cannot be negative!");
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        return result;
    }

}
