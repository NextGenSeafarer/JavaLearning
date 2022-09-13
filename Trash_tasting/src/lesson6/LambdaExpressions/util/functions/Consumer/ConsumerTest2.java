package lesson6.LambdaExpressions.util.functions.Consumer;

import java.util.ArrayList;

public class ConsumerTest2 {
    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();
        Employee employee1 = new Employee(1000, "User1", 20);
        Employee employee2 = new Employee(543, "User2", 29);
        Employee employee3 = new Employee(20, "User3", 40);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        list.forEach(employee -> {
            if(employee.id %2 == 0){
                employee.name = "*".repeat(employee.name.length());
            }
        });
        System.out.println(list);

        // Прямое изменение коллекции возможна только с generic классами
    }
}

class Employee {
    int id;
    String name;
    int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}