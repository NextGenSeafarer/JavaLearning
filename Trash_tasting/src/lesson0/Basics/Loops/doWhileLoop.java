package lesson0.Basics.Loops;

public class doWhileLoop {

    /*

    Единственная разница между while и do while loop - отсутствие unreachable statement у do while
    Хотя бы один раз цикл do while будет выполнен, даже если условие в while будет изначально false


    */


    public static void main(String[] args) {

        int a = 0;
        do {
            System.out.println(a);
            a++;
        }
        while (a <= 10);
        System.out.println("-----------");

        int b = 0;
        do {
            System.out.println(b);
            b++;
        } while (b < 0); // <- заведомо false


    }
}
