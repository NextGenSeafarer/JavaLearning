package lesson8.Multithreading;

public class ThreadVolatailEx extends Thread {

    volatile boolean b = true;
    /*
    volatile - изменчивый, изменяющийся (применяется для синхронизации потоков)
    Заставляет хранить информацию только в main memory
    хорошо работает, когда 1 нить будет изменять значение, а другие читать



                                    MAIN MEMORY
     -----------------------------------------------------------------------------
                 |                                                |
     CPU cache (high speed memory)                  CPU cache (high speed memory)
                |                                                |
            thread main                                       thread
         изменяет значение                                читает значение

         при использовании ключевого слова volatile - хранение переменных будет только в main memory
         (без хранения в cache)!
         Собственно все изменения переменной будут видны всем нитям одновременно, при хранении в cache -
         обмен данными между cache <- -> main memory может не произойти и нити не узнают об изменении общих переменных

            Синхронизированные нити - это нити, которые выполняются друг за другом, в многоядерном компьютере таким
            образом достигается Concurrency
    */

    @Override
    public void run() {
        int counter = 0;
        while (b) {
            counter++;
        }
        System.err.println("Counter is : " + counter);
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread is started!");
        ThreadVolatailEx thread = new ThreadVolatailEx();
        thread.start();
        Thread.sleep(2000);
        thread.b = false; // дает поработать thread ( для counter )
        thread.join(); // заставляет ждать main thread конца выполнения потока thread
        System.out.println("Main thread is done!");
    }
}
