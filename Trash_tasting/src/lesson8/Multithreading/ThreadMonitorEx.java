package lesson8.Multithreading;

public class ThreadMonitorEx {

    /*

    Monitor - сущность/механизм, благодаря которому достигается корректная работа при синхронизации.
    В Java у каждого класса и объекта есть привязанный к нему монитор

    Синхронизированные блоки позволяют ограничить область синхронизации теми методами, которые нужны,
    Если метод один - можно обойтись добавлением synchronized в метод, но если их несколько у одного класса,
    то необходимо использовать синхронизированные блоки, которые привязаны к одному объекту.

    Конструкторы нельзя синхронизировать!

    */

    static final Object lock = new Object(); // для синхронизации нужен один объект, если мы хотим синхронизировать
    // несколько методов

    void skypeCall() {
        synchronized (lock) { // синхронизация с помощью одного и того же объекта класса Object
            System.out.println("Skype call started");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Skype call finished");
        }
    }

    void mobileCall() {
        synchronized (lock) { // синхронизация с помощью одного и того же объекта класса Object
            System.out.println("Mobile call started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Mobile call finished");
        }
    }

    void whatsappCall() {
        synchronized (lock) { // синхронизация с помощью одного и того же объекта класса Object
            System.out.println("WhatsApp call started");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("WhatsApp call finished");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MobileCallThread());
        Thread thread2 = new Thread(new SkypeCallThread());
        Thread thread3 = new Thread(new WhatsAppCallThread());
        thread1.start();
        thread2.start();
        thread3.start();
    }


}


class MobileCallThread implements Runnable {
    public void run() {
        ThreadMonitorEx monitorEx = new ThreadMonitorEx();
        monitorEx.mobileCall();
    }
}

class SkypeCallThread implements Runnable {
    public void run() {
        ThreadMonitorEx monitorEx = new ThreadMonitorEx();
        monitorEx.skypeCall();
    }
}

class WhatsAppCallThread implements Runnable {
    public void run() {
        ThreadMonitorEx monitorEx = new ThreadMonitorEx();
        monitorEx.whatsappCall();
    }
}

