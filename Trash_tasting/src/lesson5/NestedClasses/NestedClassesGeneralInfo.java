package lesson5.NestedClasses;

public class NestedClassesGeneralInfo {

    /*
            Nested classes - вложенные классы
            Бывают:
            Вложенные статичные классы - class A
            Вложенные классы - class B
            Локальные классы (внутри методов) - LOCAL class Class C
            Анонимные классы (Anonymous class) - классы без имени

    */
    static class A {
    } // вложенный класс

    class B {
    } // inner class

    void someMethod() {
        class C {
        } // LOCAL класс
    }


}
