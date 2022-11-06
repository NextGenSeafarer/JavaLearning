package lesson0.Basics.Loops;

public class forLoop {

    /*

    For loop - стандартное написание:
    for(int i=0; i<10; i++){ тело лупа }
    Порядок действий:
    1. Инициализация int i=0 - происходит один раз
    2. Проверка условия i < 10 (true ? false), если true -> Выполнение тела, иначе выходит из лупа
    3. Затем происходит i++

    Java не допускает unreachable statements в условии for лупа

     Существуют label statements:
     NAME: for(int i=0; i<10; i++){ тело лупа }
     INNER: for(int i=0; i<10; i++){ тело лупа }

     Минимальная форма for лупа будет выглядеть как for(;;){} - бесконечный луп, так как нет условия

    */

    public static void main(String[] args) {

        //Example:

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            //числа от 0 до 9 выводятся на экран
        }
        System.out.println("-------------------------------");

        //Nested loop:

        OUTER:
        // <- label statement
        for (int i = 0; i < 100; i++) {
            INNER:
            // <- label statement
            for (int j = 0; j < 10; j++) {
                System.out.println(i + " : " + j);
                if (j == 5) {
                    break OUTER;
                }
            }

        }
        System.out.println("-------------------------------");

        HomeWorkLoops.clocks();

    }


}

class HomeWorkLoops {
    public static void clocks() {
        HOUR:
        for (int hour = 0; hour <= 6; hour++) {
            MINUTE:
            for (int minute = 0; minute < 60; minute++) {
                if (hour > 1 && minute % 10 == 0) {
                    break HOUR;
                }
                SECOND:
                for (int second = 0; second < 60; second++) {
                    if (second * hour > minute) {
                        break SECOND;
                    }
                    System.out.println(hour + " : " + minute + " : " + second);

                }
            }
        }

    }


}
