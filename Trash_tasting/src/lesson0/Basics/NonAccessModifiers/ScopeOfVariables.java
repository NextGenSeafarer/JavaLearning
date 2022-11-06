package lesson0.Basics.NonAccessModifiers;

public class ScopeOfVariables {

/*

    Существуют:

    Static variables - переменные класса, которые не принадлежат конкретному объекту, а принадлежат всему классу,
    обращение к static переменным через ключевое слово this не является ошибкой, но не рекомендуется.

    Instance variables - переменные, которые связанны с конкретным объектом, указание на эти переменные производится словом this.

    Local variables - переменные метода, или конструктора которые существуют только в пределах метода или конструктора

    Parameter variables - сами по себе параметры, которые передаются в конструкторе или в методе

*/

    public static String nameOfTheClass; // <- статические переменные, принадлежат всему классу ScopeOfVariables, не зависят от наличия или отсутствия объектов
    public String someString; // <- object instance, т.е. переменные класса, принадлежат объектам класса

    ScopeOfVariables(){}

    ScopeOfVariables(String one){ // <- переменная параметра, будет видна только в конструкторе
        boolean test; // <- локальная переменная конструктора
    }

    public void showSomeString(String toShowString) // <- переменная параметра
    {
        this.someString = toShowString; // <- local variable
        int number = 0 ; // <- local variable
        System.out.println(nameOfTheClass.repeat(5)); // <- могу обращаться к статик переменной из нон статик метода
    }
    public static void staticMethod(){
        //someString = nameOfTheClass; <- не могу обращаться к нон статик переменной из статик метода, т.к не могу точно знать,
        //существует ли объект, которому принадлежит данная переменная
        //если создать объект класса, тогда смогу обратиться:
        ScopeOfVariables scopeOfVariables = new ScopeOfVariables();
        scopeOfVariables.someString = nameOfTheClass; // <- теперь могу из статик метода обратиться, потому что есть экземпляр класса ScopeOfVariables
        //и принадлежащая ему instance variable
    }


}
