package lesson0.Basics.Methods;

public class OverloadedMethodsAndConstructors {
    /*

    Перегрузка методов - это понятие, которое допускает множество методов с одинаковым именем, но с разными параметрами
    Перегрузка конструкторов - само по себе логично, конструкторы с одинаковыми именами, но разными входными параметрами


    */

}

class Overload {

    int one;
    int two;
    String str;
    boolean bool;

    void showInfo(int one, int two) { // <- Overloaded Method
        System.out.println(one + " " + two);
    }

    void showInfo(int one) { // <- Overloaded Method
        System.out.println(one);
    }

    //----------------------------------------------------------------------------------

    Overload(int one, int two, String str, boolean bool) { // <- Overloaded Constructor
        System.out.println("Its overloaded method with all parameters possible!");
    }

    Overload(int one, int two, String str) { // <- Overloaded Constructor


        this(one, two, str, false); // слово this позволяет обращаться к конструктору внутри конструктора!
        //слово this должно стоять самым первым

        System.out.println("Its overloaded method with 3 parameters!");
    }

    Overload(int one, int two) { // <- Overloaded Constructor
        this(one, two, null, false);
        System.out.println("Its overloaded method with 2 parameters!");
    }

    Overload(int one) { // <- Overloaded Constructor
        this(one, 0, null, false);
        System.out.println("Its overloaded method with 1 parameter!");
    }

    Overload() { // <- Default Constructor
        System.out.println("Its Default constructor!");
    }

    public static void main(String[] args) {
        Overload overload = new Overload(1); // при таком вызове будет использоваться 2 конструктора (со всеми параметрами и с одним)

        overload.showInfo(10000); // один из перегруженных методов класса Overload
    }

}
