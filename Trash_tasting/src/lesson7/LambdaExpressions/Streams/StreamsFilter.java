package lesson7.LambdaExpressions.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsFilter {
    /*
    .filter нужен непосредственно для фильтрации входящих в стрим элементов, осуществляется путем использования
    функционального интерфейса Predicate<T>
     */


    public static void main(String[] args) {

        System.out.println("<--------------------------ORIGINAL LIST IS LOOKS LIKE:---------------------------------------->");

        List<Seafarer> seafarerList = new ArrayList<>();
        seafarerList.add(new Seafarer("User1", "Surname1", 20, 21222, 3000));
        seafarerList.add(new Seafarer("User2", "Surname2", 34, 18500, 5000));
        seafarerList.add(new Seafarer("User3", "Surname3", 41, 14676, 8200));
        seafarerList.add(new Seafarer("User4", "Surname4", 21, 20664, 1340));
        seafarerList.add(new Seafarer("User5", "Surname5", 26, 21232, 3500));
        System.out.println(seafarerList);

        //как бы пришлось фильтровать раньше по возрасту и зарплате раньше:

        System.out.println("<--------------------------After filtration by forEachLoop below---------------------------------------->");

        for (Seafarer s : seafarerList) {
            if (s.getAge() > 22 && s.getSalary() > 3200) {
                System.out.println(s);
            }
        }


        System.out.println("<--------------------------After filtration by LAMBDA below---------------------------------------->");
        //Более продвинутый способ:
        Predicate<Seafarer> filterByAge = seafarer -> seafarer.getAge() > 22;
        Predicate<Seafarer> filterBySalary = seafarer -> seafarer.getSalary() > 3200;
        showSeafarersByFilter(seafarerList, filterByAge.and(filterBySalary));


        System.out.println("<--------------------------After filtration by STREAM below---------------------------------------->");
        //самый короткий и понятный способ со Stream:
        List<Seafarer> list = seafarerList.stream().filter(seafarer -> seafarer.getAge() > 22 && seafarer.getSalary() > 3200).collect(Collectors.toList());
        System.out.println(list);


    }

    static void showSeafarersByFilter(List<Seafarer> al, Predicate<Seafarer> predicate) {
        for (Seafarer s : al) {
            if (predicate.test(s)) {
                System.out.println(s);
            }
        }

    }
}


class Seafarer {
    private String name;
    private String surname;
    private int age;
    private int id;
    private double salary;

    public Seafarer(String name, String surname, int age, int id, double salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\n" + "Seafarer: " + name.replaceAll("\\D+", "") + "\n " + name + "\n  " + surname + "\n   " + id + "\n    " + age + "\n     " + salary;
    }

}
