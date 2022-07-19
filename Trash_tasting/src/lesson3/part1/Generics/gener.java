package lesson3.part1.Generics;


/*
Java Generics - функция языка, позволяющая определять и использовать общие типы и методы

Две причины иметь generics :
1. Type safe
2. Reusable Code

1.Т.е. если ArrayList<String> - то в него можно положить только String и любая ошибка будет отображаться при компиляции
я не смогу положить туда Integer или любой другой объект другого класса
2. Описание того, какие объекты будут храниться в массиве - прописано один раз, что избавляет от клонирования кода
*/


public class gener {

    public static void main(String[] args) {
        Info<String> info1 = new Info<>("My name");
        System.out.println(info1); // вернет [My name]

        Info<Integer> info2 = new Info<>(50);
        System.out.println(info2); // вернет [50]


        // Данный пример, как в HashMap, т.е. для двух типов значений
        Info2<String, Integer> info3 = new Info2<>("Ilia", 26);
        System.out.println("name: " + info3.getValue1() + ", age: " + info3.getValue2()); // вернет name: Ilia, age: 26


        // Данный пример для нескольких полей одного типа
        Info3<String> info4 = new Info3<>("Ilia", "Pochinskii");
        System.out.println("first name: " + info4.getValue1() + ", second name : " + info4.getValue2()); // вернет first name:Ilia, second name :Pochinskii

    }


}

// класс с 1 параметром и одним полем
class Info<T> {
    private T value;

    public Info(T value) {
        this.value = value;
    }

    public String toString() {

        return "[" + value + "]";
    }
}

// класс с 2 параметрами и двумя полями

class Info2<V1, V2> {

    private V1 value1;
    private V2 value2;

    public Info2(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }
}

// класс с 1 параметром для двух полей

class Info3<V> {

    private V value1;
    private V value2;

    public Info3(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getValue1() {
        return value1;
    }

    public V getValue2() {
        return value2;
    }

}





