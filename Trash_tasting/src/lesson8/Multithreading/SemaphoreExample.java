package lesson8.Multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    /*

    Semaphore - один из видов синхронизаторов высокого уровня со своей логикой,
    обладает многими методами, но главные:
    .acquire() - то же самое что и Lock lock = new Lock()  -> lock.lock(); получает разрешение на использование треда
    в зависимости от количества пермитов, которые мы передали в конструкторе самого семафора - будет уменьшать внутренний
    счетчик при использовании потоком метода данного треда.
    Количество пермитов = 2 -> при использовании тредом метода нашего класса, имплементирующего Runnable счетчик станет 1
    при использовании ещё одним тредом станет 0, тогда остальные потоки, которые хотят использовать наш класс будут
    заморожены, пока не освободится хотя бы один тред из использующих в данный момент

    .release() - освобождает поток, лучше всего писать в finally, чтобы при любом раскладе не залочить тред навечно

    */


    public static void main(String[] args) throws InterruptedException {

        Semaphore callBox = new Semaphore(1);

        new PersonUsingCallBox("Ilia", callBox);
        new PersonUsingCallBox("Daria", callBox);
        new PersonUsingCallBox("Kirill", callBox);
        new PersonUsingCallBox("Elena", callBox);
        new PersonUsingCallBox("Andrey", callBox);




    }
}

class PersonUsingCallBox extends Thread {
    private final String name;
    private final Semaphore callBox;

    public PersonUsingCallBox(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start(); // запускаем тред сразу после создания конструктором нашего объекта
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s is waiting...\n", name);
            callBox.acquire(); // проверяем внутренним счетчиком, что можно использовать, иначе -> заморозка треда
            System.out.printf("%s is using the phone...\n", name);
            sleep(4000);
            System.out.printf("%s is finished his(her) call\n", name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            callBox.release(); // при любом раскладе разлочиваем наш тред, чтобы можно было его использовать
        }
    }
}
