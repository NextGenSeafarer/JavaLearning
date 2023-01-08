package lesson0.Basics.OOP;

public class Polymorphism {
    /*
    Полиморфизм - это способность объекта принимать множество форм.
    Объект считается полиморфным, если он имеет более 1 связи IS-A
    Полиморфизм - это способность метода вести себя по-разному в зависимости от того, объект какого класса
    вызывает этот метод
    Override methods часто называют полиморфными

    ***
    Upcasting && Down casting возможен только между классами с IS A relationship
    Upcasting происходит автоматически, т.е. если я пишу
    Employee emp = new Driver();
    Я делаю upcast driver до employee
    String [] array1 = {"hello", "world"};
    Object [] array2 = array1;
    Здесь происходит автоматический upcast из массива типа String в массив типа Object

    Если же я пишу:
    Driver d = (Driver) emp; - я делаю DOWN CAST с помощью которого говорю компилятору, что d - может быть driver
    String [] array1 = {"hello", "world"};
    Object [] array2 = array1;
    String [] array 3 = (String []) array2; - это down cast из массива типа Object до массива типа String

    Оператор типа instanceof может быть использован только при взаимоотношении IS A
    Возвращает true, если объект имеет данное отношение и false, если не имеет соответственно

     */
}

class Employee {
    String name;
    int age;

    void eat() {
        System.out.println("Employee eats");
    }

    void sleep() {
        System.out.println("Employee sleeps");
    }
}

class Doctor extends Employee {
    String proficiency;

    @Override
    void eat() {
        System.out.println("Doctor eats");
    }

    @Override
    void sleep() {
        System.out.println("Doctor sleeps");
    }

    void heal() {
        System.out.println("Doctor is healing");
    }
}

class Test {
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        // есть доступ к:
        int age = doctor.age;
        String name = doctor.name;
        String prof = doctor.proficiency;
        doctor.eat();
        doctor.sleep();
        doctor.heal();
        //---------------------------------
        Employee emp = new Doctor();
        // есть доступ к:
        int age1 = emp.age;
        String name1 = emp.name;
        emp.eat();
        emp.sleep();
        //emp.heal(); // <- доступа нет, хотя emp и ссылается на Doctor
        ((Doctor) emp).heal(); // <- с таким downcast получается вызвать метод
        //String prof2 = emp.proficiency; // <- доступа нет, ибо emp - это не доктор, хоть и ссылается на него
        String prof3 = ((Doctor) emp).proficiency; // <- а вот так есть доступ, ибо мы кастим Employee до Doctor

    }
}

