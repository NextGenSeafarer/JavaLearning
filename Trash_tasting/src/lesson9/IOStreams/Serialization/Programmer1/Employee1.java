package lesson9.IOStreams.Serialization.Programmer1;

import java.io.Serial;
import java.io.Serializable;

public class Employee1 implements Serializable {
    /*
    Классы, которые будут сериализировать должны иметь поле serialVersionUID!
    Для указания версии сериализованного объекта и для сравнения во время десериализации
    */

    @Serial
    private static final long serialVersionUID = 1; // указатель версии!
    String name;
    String rank;
    int age;
    char sex;
    transient int salary; // <------------- transient (временный), указывает на поле, которому будет присвоено стандартное значение при сериализации
    // необходимо для скрытия данных при передаче какой - либо информации
    Car car;

    public Employee1(String name, String rank, int age,
                     char sex,
                     int salary, Car car) {
        this.name = name;
        this.rank = rank;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", salary=" + salary +
                ", car=" + car +
                '}';
    }
}
