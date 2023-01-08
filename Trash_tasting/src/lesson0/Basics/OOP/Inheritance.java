package lesson0.Basics.OOP;

public class Inheritance {

    /*

    Inheritance - один из принципов ООП, позволяющий расширять классы путем наследования
    Зачем:
    - более короткое написание классов
    - лёгкость изменении/добавлении общих элементов
    - Extensibility
    - Более легкое тестирование классов
    - Группировка классов под общим типом

      Существует 2 вида взаимоотношения между классами
      Is-a <- например Mouse extends Animal, значит, что Mouse is Animal, мышь - наследник Animal
      Has-a <- например в class House объявлена переменная reference type Roof, взаимоотношение будет House has a roof! Имеет что - то

    class Animal -> extends java.lang.Object <- то, что jvm допишет сама, т.к. любой класс является потомком Object класса
    {
    private String name;

    public void run(){}
    public void makeNoise(){}
    }

    class Dog extends Animal{ т.е. класс Dog расширяет класс Animal, класс родитель - всегда более общий, а наследник - более уточненный

    }

    Родительский класс может иметь имя: Parent class, Base class, Super class
    Класс наследник может называться: Subclass, Derived (вторичный) class, child class, extended class

    Переменная супер класса может ссылаться на объект child класса
    class Employee{}
    class Teacher extends Employee{}
    class Driver extends Employee{}
    class Doctor extends Employee{}


    Employee em1 = new Teacher();   Teacher is Employee
    Employee em2 = new Driver();    Driver is Employee
    Employee em3 = new Doctor();    Doctor is Employee

    class Test {
    public Animal abc(){
    return new Mouse();  <- такая запись справедлива, потому что Mouse is Animal
        }
    }

    Method Overriding: @Override

    Это изменение non-static, non-final метода в sub классе, который унаследован от parent класса.

    Методы могут считаться перезаписанными, если:
    -   Имена в sub классе и parent классе совпадают

    class A{
    void foo(){ <- имена совпадают
        sout("Hello");
        }
    }
    class B extends A {
    void foo(){ <- имена совпадают
    sout("Hello World!");
        }
    }

    -   Список параметров методов совпадают
    -   Return type такой же, или является sub классом sub класса*** (covariant return types)

    ***
    class Employee{}

    class Doctor extends Employee{
    public Employee abc(){
    return new Doctor(); <- return type является sub классом Employee
       }
    }

    class Xirurg extends Doctor{
    public Doctor abc(){
    return new Xirurg(); <- return type является sub классом Doctor
       }
    }

    -   Access modifier такой же или менее строгий чем в parent class
    Потому что по логике каждый child class должен наследовать все методы parent class, если
    какой - то из классов сделает метод private - остальные наследники этого класса не смогут
    унаследовать данный метод, поэтому:
    При модификаторе public у parent class -> public у child class
    При модификаторе protected у parent class -> public или protected у child class
    При модификаторе default у parent class -> public или default или protected у child class
    При модификаторе private у parent class -> не наследуются

    -Метод в sub class тоже должен быть non-static



    Binding - определение вызываемого метода, основываясь на объекте, который производит вызов или типе данных reference variable
    Существует 2 типа binding:
    ->        Compile time binding (static binding) -> static, final & private methods <- те, которые не могут быть перезаписаны в sub class
    ->        Run time binding (dynamic binding) -> все остальные классы
    !!! Все переменные имеют compile time binding (т.е. переменные ещё до запуска определены к какому классу они относятся)



    psvm{
    Test t = new Test();
    Animal animal = new Mouse();
    t.abc(animal); <- здесь animal является как бы переменной, поэтому проверку на runtime binding не нужно делать, на экран выведется "A"
    animal.getName(); <- здесь уже проверка нужна, логика простая: getName() final||static||private ? вызываем в классе Animal : вызываем в классе Mouse используя Runtime binding
    }

    class Test{
    void abc(Animal a){sout"A"}
    void abc(Mouse m){sout"M"}
    }

    class Animal{
    void getName(){sout"Animal"}
    }

    class Mouse{
    void getName(){sout"Mouse"}
    }

    Method hiding - это перекрытие методов parent class в sub class
    - имя одинаковое
    - список параметров одинаковый
    - return type такой же или ковариантный
    - менее строгий или такой же модификатор доступа
    - если в parent классе метод является static, то и в sub class он должен быть static

    !!! Variable hiding - объявление в sub class переменной с таким же именем (не обязательно типом), что и в parent class
    Parent class{
    int salary = 200;
    }
    Child class extends Parent {
    String salary = " TWO HUNDRED ";
    }
    Parent parent = new Child();
    parent.salary - будет "TWO HUNDRED", потому что сработало сокрытие salary из parent класса путем добавления в child class


*/


}
