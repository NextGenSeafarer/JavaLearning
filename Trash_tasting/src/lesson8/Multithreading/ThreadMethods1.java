package lesson8.Multithreading;

public class ThreadMethods1 {

    /*
    getName - получение имени потока
    setName - установка имени потока
    getPriority - получение приоритета потока
    setPriority - установка приоритета потока (от 1 до 10) - 1 - минимум, 10 - максимум приоритетности


     */


    public static void main(String[] args) {
        Thread5 thread5 = new Thread5();
        System.out.println("MY THREAD name: " + thread5.getName() + "\nAnd its priority is: " + thread5.getPriority() + "\n");

        Thread5 thread6 = new Thread5();
        thread6.setName("ZLOY POTOK");
        thread6.setPriority(Thread.MAX_PRIORITY);
//        thread6.setPriority(Thread.NORM_PRIORITY); - варианты создания приоритета потока
//        thread6.setPriority(Thread.MIN_PRIORITY);
        System.out.println("MY THREAD name: " + thread6.getName() + "\nAnd its priority is: " + thread6.getPriority());

    }

}

class Thread5 extends Thread {
    public void run() {
        System.out.println("HELLO!");
    }
}