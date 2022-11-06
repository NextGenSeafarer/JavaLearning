package lesson0.Basics.AccessModifiers.packageB;


public class SomeClass {
    public String getIt;
    String getGetIt;

    public static void main(String[] args) {

        lesson0.Basics.AccessModifiers.packageA.SomeClass object = new lesson0.Basics.AccessModifiers.packageA.SomeClass();
        //полный путь к другому классу в другом пакете public type
        object.sayHello();

        lesson0.Basics.AccessModifiers.packageA.ProtectedClass o = new lesson0.Basics.AccessModifiers.packageA.ProtectedClass();
        //  o.name; <- protected, поэтому не видно из другого класса


    }


}
