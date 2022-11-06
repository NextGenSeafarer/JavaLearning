package lesson8.Multithreading;

public class WorkerSleepMainWait implements Runnable{
    @Override
    public void run() {
        System.out.println("I'm starting the work!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("JOB DONE!");
    }

    public static void main(String[] args) throws InterruptedException {
        System.err.println("Method main is just started");

        Thread thread = new Thread(new WorkerSleepMainWait());
        thread.setName("MY WORKER THREAD");
        System.out.println("STATE AFTER IT WAS CREATED: " + thread.getState());
        thread.start();
        System.out.println("STATE AFTER IT WAS STARTED: " + thread.getState());
        thread.join(1000);
        // метод join принимает параметр в секундах, если ждать дольше чем выполняется метод run
        // тогда main продолжит работу после истечения это времени, допустим у меня 3 секунды на выполнение thread
        // если в join будет 1, тогда main продолжит работу до того как доспит поток
        // если в join будет 4, тогда main продолжит сразу же как закончит поток thread
        System.out.println("STATE (WAITING) " + thread.getState());
        System.err.println("Method main is finished");


    }
}
