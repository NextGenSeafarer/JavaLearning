package lesson0.Basics.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaHW1 {
}

class Employee {
    private String name;
    private String department;
    private double salary;

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


}

class TestEmployee {
    void printEmployee(Employee emp) {
        System.out.println("Employee name: " + emp.getName() + ", department: " + emp.getDepartment() + ", salary: " + emp.getSalary());
    }

    void employeeFilter(List<Employee> employeeList, Predicate<Employee> emp) {
        for (Employee e : employeeList) {
            if (emp.test(e)) {
                printEmployee(e);
            }
        }
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Ilia", "IT", 3000));
        list.add(new Employee("Oleg", "IT", 150));
        list.add(new Employee("Kirill", "IT", 333));
        list.add(new Employee("Engineer", "Engineer", 422));
        list.add(new Employee("Egor", "DevOps", 450));
        list.add(new Employee("Evgenii", "DevOps", 666));
        TestEmployee ts = new TestEmployee();
        ts.employeeFilter(list, x -> x.getDepartment().equals("IT") && x.getSalary() > 200);
        System.out.println("-------------------------------");
        ts.employeeFilter(list, x -> x.getName().startsWith("E") && x.getSalary() != 450);
        System.out.println("-------------------------------");
        ts.employeeFilter(list, x-> x.getName().equals(x.getDepartment()));

    }

}