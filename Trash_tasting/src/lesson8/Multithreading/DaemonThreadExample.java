package lesson8.Multithreading;

public class DaemonThreadExample {


    /*

    Daemon потоки - второстепенные потоки, которые прерываются тогда, когда не остается рабочих user threads
    не дожидаясь их окончания, используются для сервиса user потоков

    setDaemon(true) - необходимо устанавливать до запуска потока демона!!!!
    иначе будет исключение !

    */


    public static void main(String[] args) {
        System.out.println("Main thread STARTS!");

        UserThread userThread = new UserThread();
        DaemonThread daemonThread = new DaemonThread();
        userThread.setName("USER THREAD");
        daemonThread.setName("DAEMON THREAD");
        daemonThread.setDaemon(true); // делаем daemonThread потоком демоном !!!! ДО СТАРТА ПОТОКА ДЕМОНА !!!!!
        userThread.start();
        daemonThread.start();
        System.out.println("Main thread FINISHED!");

    }
}

class UserThread extends Thread {
    public void run() {
        System.out.println(currentThread().getName() + " is daemon: " + isDaemon());
        for (char i = 'A'; i <= 'Z'; i++) {
            try {
                sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
        System.out.println("User Thread IS FINISHED!");
    }
}

class DaemonThread extends Thread {
    public void run() {
        System.out.println(currentThread().getName() + " is daemon: " + isDaemon());
        for (int i = 0; i <= 20; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.err.println("IM DEMON AND I'M HERE!\nHere is my number: " + i + "\nMy target is 20!");
        }
        System.out.println("DAEMON THREAD IS FINISHED! ");
    }
}
