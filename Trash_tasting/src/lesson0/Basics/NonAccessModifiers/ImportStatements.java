package lesson0.Basics.NonAccessModifiers;

/*

    Существует 2 типа import statements:
    import - используется для импорта не статичных переменных из другого класса
    import static - используется для импортирования статичных переменных из класса другого пакета
    Больше не работает import static!

*/

import lesson0.Basics.AccessModifiers.packageA.SomeClass;


public class ImportStatements {

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        String a = someClass.str; // <- использование не статик переменной
        int b = SomeClass.someNum; // <- использование статик переменной


    }


}
