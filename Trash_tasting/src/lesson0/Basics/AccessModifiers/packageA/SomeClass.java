package lesson0.Basics.AccessModifiers.packageA;

public class SomeClass {
    public int number; // <- есть доступ из всей программы
    public String str; // <- есть доступ из всей программы
    public static int someNum = 99;

    public void sayHello() {
        System.out.println("Hello!");
    }

    private double salary = 9999.9999;

}

class AnotherClass {

    static {
        SomeClass someClass = new SomeClass();
        //someClass.salary; <- пытаюсь вызвать в том же пакете, но не могу, т.к. поле private
        lesson0.Basics.AccessModifiers.packageB.SomeClass sc = new lesson0.Basics.AccessModifiers.packageB.SomeClass();
        String one = sc.getIt; // <- public поле
        //String two = sc.getGetIt; <- default поле, не могу получить доступ из другого пакета
    }


}
