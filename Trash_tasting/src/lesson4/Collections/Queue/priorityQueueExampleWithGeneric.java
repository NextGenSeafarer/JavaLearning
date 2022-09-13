package lesson4.Collections.Queue;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class priorityQueueExampleWithGeneric {

    /*
    При использовании priorityQueue с generic классами необходимо имплементировать интерфейс Comparable
    либо же прямо к коллекции прописывать Comparator, иначе добавление элементов будет невозможно и выбросится
    исключение
     */
    public static void main(String[] args) {
        Seafarer cadet = new Seafarer("John", 1000);
        Seafarer secondEng = new Seafarer("Ilia", 3500);
        Seafarer OS = new Seafarer("Kelly", 1250);
        Seafarer AB = new Seafarer("Paul", 1600);
        Seafarer gasEng = new Seafarer("Bernie", 5800);
        Seafarer thirdEng = new Seafarer("Jake", 2850);

        PriorityQueue<Seafarer> seafarerPriorityQueue = new PriorityQueue<>(new Comparator<Seafarer>() {
            @Override
            public int compare(Seafarer o1, Seafarer o2) {
                return (int) (o1.getSalary() - o2.getSalary()); // сравниваем по зарплатам
            }
        });
        seafarerPriorityQueue.add(cadet);
        seafarerPriorityQueue.add(secondEng);
        seafarerPriorityQueue.add(OS);
        seafarerPriorityQueue.add(AB);
        seafarerPriorityQueue.add(gasEng);
        seafarerPriorityQueue.add(thirdEng);
        System.out.println(seafarerPriorityQueue);
        System.out.println(seafarerPriorityQueue.remove());
        System.out.println(seafarerPriorityQueue.remove());
        System.out.println(seafarerPriorityQueue.remove());
        System.out.println(seafarerPriorityQueue.remove());
        System.out.println(seafarerPriorityQueue.remove());
        System.out.println(seafarerPriorityQueue.remove());
        // Удаление происходит по принципу элемента с наибольшим приоритетом, соответственно - с наименьшей зарплатой

    }


}

class Seafarer {
    private String name;
    private double salary;

    @Override
    public String toString() {
        return "Seafarer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Seafarer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seafarer seafarer = (Seafarer) o;
        return Double.compare(seafarer.salary, salary) == 0 && Objects.equals(name, seafarer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}

