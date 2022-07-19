package lesson2.part1.interfaceComparable;


import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee another) {
        // если 1, то это > (больше)
        // если -1, то это < (меньше)
        // если 0, то это = (равно)

        return this.salary - another.salary;

    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {

        return emp1.name.compareTo(emp2.name);
    }
}

class IdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {

        return emp1.id - emp2.id;
    }
}

