package lesson0.Basics.OOP;

public class AbstractClassesAndInterfaces {
}

abstract class Shape {
    abstract double perimeter(); // <- у абстрактных методов не может быть тела

    abstract double square();

    /*
    Shape shape = new Shape(); абстрактный класс не может создавать объекты
    'Shape' is abstract; cannot be instantiated

    Eсли в классе есть хоть 1 абстрактный метод, тогда и класс должен быть абстрактным
    Child класс должен либо перезаписать все abstract methods или же стать абстрактным

    Интерфейс - это конструкция языка (публичный контракт), который определяет поведение класса, который его имплементировал
    Если класс имплементирует интерфейс - он должен определить реализацию абстрактных методов этого интерфейса или сам стать абстрактным
    Интерфейс дает гарантию наличия методов в классе.
    Основные моменты:
    - невозможно создать объект интерфейса, потому что это не класс
    - т.к. невозможно создать объект, то и конструкторов у интерфейса нет
    - access modifier топ левел интерфейсов или public, или default (потому он и публичный контракт)
    - интерфейс не может быть final, ибо тогда его нельзя будет имплементировать и перезаписывать его методы
    - если не указать самостоятельно, тогда компилятор сам добавит ->abstract public<- interface
    - методы интерфейса не могут быть final
    - из переменных в интерфейсе могут быть только константы (они будут public static final)


    From Java 8:
    Default methods in interfaces
    Это методы, которые обозначаются ключевым словом default в интерфейсе, у них всегда есть реализация прямо
    в интерфейсе, зачем это нужно?
    Допустим у нас есть 1000 классов, которые имплементируют какой - то интерфейс, если в этот интерфейс добавить
    ещё один метод, тогда 1000 классов должны будут переопределить этот метод, а что, если только 10 из 1000 классов
    нужен данный метод?
    Тогда и целесообразно использовать default method, если не нужно перезаписывать - тогда можно
    использовать стандартную реализацию, иначе можно и переопределить.

    Static methods in interfaces
    Статические методы в интерфейсах не наследуются, возможность их вызова зависит только от видимости этих методов
    Вызывать статические методы можно путем InterfaceName.method();

    From Java 9:
    С 9 Java появились private methods & private static methods в Interfaces
    Правила:
    Такой метод не может быть abstract
    Такой метод может быть использован только внутри интерфейса
    Зачем это надо?
    Для более сложной внутренней реализации интерфейса, где какие - то операции будут скрыты внутри интерфейса.


     */

}

@FunctionalInterface
interface Printable {
    void print(); // <- методы все и всегда должны быть доступны для переопределения при имплементации
}

class PrintingDevice {
    public static void printNameOfDevice(Printable someClassImplementsPrintable) {
        someClassImplementsPrintable.print();
    }
}

class Printer extends PrintingDevice{}
class Fax extends PrintingDevice{}

class Test0 {
    public static void main(String[] args) {
        Printer.printNameOfDevice(() -> System.out.println("I'm printer"));
        Fax.printNameOfDevice(()-> System.out.println("I'm fax"));
    }
}





