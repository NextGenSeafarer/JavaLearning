package lesson0.Basics.VarARGS;

public class VarArgsInf {
    /*

    Variable arguments - параметры, которые передаются в командной строке
    public static void main(String[] args)
    args - и есть параметры, которые передаются при запуске метода main
    Для любого метода можно передать неопределенное количество параметров, к примеру вместо того, чтобы
    перегружать методы по типу:

    public static int sum(int a, int b){
    return a + b;
    }
    public static int sum(int a, int b, int c){
    return a + b + c;
    }
    public static int sum(int a, int b, int c, int d){
    return a + b + c + d;
    }
    Можно предать неопределенное количество параметров (от нуля до бесконечности)
    public static int sum (int ... a){
    int sum = 0;
    for(int i = 0; i < a.length; i++){
    sum+=a[i];
    }
    return sum;
    }




    */

    public static void main(String... args) { // <- то же самое касается метода main
        System.out.println("sum: " + sum(0, 1, 2, 3, 4, 5));

    }

    public static int sum(int... a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}

