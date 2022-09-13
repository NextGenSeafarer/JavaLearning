package lesson5.NestedClasses;

public class AnonymousClassExample {
    /*
    Анонимные классы нужны для создания классов без имени.
    Анонимный класс - это объявление класса и создание объекта одновременно.
    В анонимных классах нельзя записать конструктор, так как нет имени класса.
    Анонимный класс может обращаться к private переменным внешнего класса.
    Lambda expressions - краткая форма записи анонимного класса.
    Обычно анонимный класс нужен - чтобы вызвать какой-то класс с его методами единожды, на ходу, в других случаях
    необходимо наследоваться от класса, методы которых хочется использовать постоянно.

     */

    private int someHidedInt = 10;

    public static void main(String[] args) {

        doMathematics plusCalculation = new doMathematics() {
            @Override
            public int calculateSomething(int a, int b) {
                return a + b;
            }
        };
        System.out.println("a + b = " + plusCalculation.calculateSomething(2, 4));

        doMathematics multiplyCalculation = new doMathematics() {
            @Override
            public int calculateSomething(int a, int b) {
                AnonymousClassExample ac = new AnonymousClassExample(); // создаем объект внешнего класса
                int notHidedInt = ac.someHidedInt; // инициализируем новую переменную в анонимном классе используя private int из внешнего класса
                System.out.println("Just printing private variable from outer class: " + notHidedInt);
                return a * b;
            }
        };
        System.out.println("a * b = " + multiplyCalculation.calculateSomething(2, 4));


    }

    interface doMathematics {
        int calculateSomething(int a, int b);
    }

}
