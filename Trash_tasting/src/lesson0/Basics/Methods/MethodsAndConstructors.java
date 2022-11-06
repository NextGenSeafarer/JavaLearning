package lesson0.Basics.Methods;

public class MethodsAndConstructors {
    /*

    Конструктор - метод создания нашего объекта.

    Существует 2 вида конструкторов:
    Default - создается JMV самостоятельно, не имеет параметров, т.е. всегда вида ClassName(){}, тело всегда пустое
    User defined - определяется юзером, может иметь или не иметь параметров, т.е. вида ClassName(){} или ClassName(String o){}, тело пустое или нет

    Имя конструктора = имени класса ВСЕГДА

    Метод - модель поведения нашего класса.
    Разница между конструктором и методом - наличие возвращаемого типа у метода, при этом конструктор не имеет возвращаемого типа (ни void, ни какой - либо тип переменной)

    Параметр - это переменная, которая задается в конструкторе, или методе, например ClassName(String name){}  <<<  name - параметр
    Аргумент - передаваемое значение, т.е. ClassName ("ILIA") - ILIA - это аргумент

    SomeClass someClass = new SomeClass(){}
      type    variable         method

      type - тип переменной reference type
      variable - переменная, хранящая ссылку на объект
      method - он же конструктор, который создает объект в памяти

      SomeClass someClass; создаст ссылку = null
      new SomeClass(){} - создаст объект без ссылки

    */
}

class BankAccountEx {
    int id;
    String ownerName;
    double balance;

    public BankAccountEx() { // <- default constructor
        System.out.println(BankAccountEx.this + " was created successfully!");
    }

    BankAccountEx(int id1, String ownerName1, double balance1) { // <- конструктор
        id = id1;
        ownerName = ownerName1;
        balance = balance1;
    }

    void printInfo() { // <- метод
        System.out.println("ID: " + id + ", OWNER NAME " + ownerName);
    }

    void printInfo2(String carBrand) { // <- метод
        System.out.println("ID: " + id + ", OWNER NAME " + ownerName + ", Car brand: " + carBrand);
    }

    public static void main(String[] args) {
        BankAccountEx bankAccountEx1 = new BankAccountEx();
        System.out.println("---------------------------------");

        BankAccountEx bankAccountEx = new BankAccountEx(1, "Ilia", 20.4);
        bankAccountEx.printInfo();
        System.out.println("---------------------------------");
        bankAccountEx.printInfo2("Toyota");


    }
}