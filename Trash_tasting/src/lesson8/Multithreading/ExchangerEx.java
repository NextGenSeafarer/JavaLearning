package lesson8.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerEx {


    /*

    Exchanger - вид синхронизатора, при котором поток будет заблокирован, пока все треды, которые используют
    сам exchanger не передадут туда свое действие
    Ниже будет очередная реализация камень, ножницы, бумага

    */

    public static void main(String[] args) {

        Exchanger<Actions> exchanger = new Exchanger<>();

        List<Actions> list1 = new ArrayList<>(); // лист для наших экшенов1
        List<Actions> list2 = new ArrayList<>(); // лист для наших экшенов2
        // будем передавать действия в exchanger из листа

        list1.add(Actions.PAPER);
        list1.add(Actions.PAPER);
        list1.add(Actions.SCISSORS);


        list2.add(Actions.ROCK);
        list2.add(Actions.SCISSORS);
        list2.add(Actions.ROCK);

        new Friend("Vasya", exchanger, list1);
        new Friend("Kolya", exchanger, list2);


    }
}

enum Actions {
    ROCK, PAPER, SCISSORS;
}

class Friend extends Thread {
    private final String name;
    private final Exchanger<Actions> exchanger;
    private final List<Actions> list;

    public Friend(String name, Exchanger<Actions> exchanger, List<Actions> list) {
        this.name = name;
        this.exchanger = exchanger;
        this.list = list;
        this.start();
    }

    public void doAction(Actions myAction, Actions friendAction) {
        if ((myAction == Actions.PAPER && friendAction == Actions.ROCK) ||
                (myAction == Actions.SCISSORS && friendAction == Actions.PAPER) ||
                (myAction == Actions.ROCK && friendAction == Actions.SCISSORS)) {
            System.out.printf("%s WINS!\n", name);
        }
    }

    public void run() {
        Actions reply;
        for (Actions action : list) {
            try {
                reply = exchanger.exchange(action); // передаем значение нашего экшена из листа, как только оба переданы - будет выполняться метод doAction
                doAction(action, reply);
                sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}


