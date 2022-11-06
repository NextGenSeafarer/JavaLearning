package lesson8.Multithreading;

public class DeadlockExample {


    /*

    Deadlock - понятие, когда threads блокируются на разных объектах навсегда
    никакой работы не выполняется, они просто заблокированы

    Livelock - понятие, когда threads блокируются, но работа выполняется (например один thread записывает что - то
    в коллекцию, а второй удаляет) при этом завершения работы метода не случится, потому что потоки оставляют всё на
    одном месте записывая и стирая информацию поочередно

    Lock starvation - ситуация, когда менее приоритетные потоки ждут своей очереди чтобы запуститься,
    Допустим есть T1, T2, T3, T4, T5
    T1 -> заходит в синхронизированный метод, выполняется работа
    T2 -> заходит в синхронизированный метод, выполняется работа (создается ещё поток с высоким приоритетом T6)
    T6 -> заходит в синхронизированный метод, выполняется работа (создается ещё поток с высоким приоритетом T7)
    И т.д, тем временем остальные потоки с низким приоритетом просто ждут, но могут никогда не выполнить работу из-за
    создания более приоритетных потоков



    Для избежания deadlock - необходимо синхронизироваться в одинаковом порядке (если используются разные объекты для
    синхронизации)



    */

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread10 = new Thread10();
        Thread thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }
}

class Thread10 extends Thread{
    public void run(){
        System.out.println("Thread10: попытка захватить монитор объекта lock1");
        synchronized (DeadlockExample.lock1){
            System.out.println("Thread10: монитор объекта lock1 захвачен");
            System.out.println("Thread10: попытка захватить монитор объекта lock2");
            synchronized (DeadlockExample.lock2){
                System.out.println("Thread10: монитор объекта lock2 захвачен");
            }
        }
    }
}

class Thread20 extends Thread{
    public void run(){
        System.out.println("Thread20: попытка захватить монитор объекта lock2");
        synchronized (DeadlockExample.lock2){
            System.out.println("Thread20: монитор объекта lock2 захвачен");
            System.out.println("Thread20: попытка захватить монитор объекта lock1");
            synchronized (DeadlockExample.lock1){
                System.out.println("Thread20: монитор объекта lock1 захвачен");
            }
        }
    }
}

