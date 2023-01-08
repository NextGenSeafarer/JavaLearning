package lesson0.Basics.OOP;

public class toStringAndEquals {
    /*
    Метод equals в правильной реализации должен в качестве параметра принимать объект типа Object
    ТОЛЬКО В ЭТОМ СЛУЧАЕ МЕТОД КЛАССА OBJECT БУДЕТ ПЕРЕЗАПИСАН, иначе же мы просто пишем делаем overload метода equals()
    Правильно перезаписанный метод equals() должен обладать следующими свойствами:
    1. Симметричность - для non-null ссылочных переменных a.equals(b) && b.equals(a) должны вернуть true
    2. Рефлексивность - для non-null ссылочных переменных a.equals(a) всегда true
    3. Транзитивность - для non-null ссылочных переменных a, b, c, если a.equals(b) и b.equals(c), тогда a.equals(c)
    4. Постоянство - не зависимо от количества вызовов a.equals(b) всегда или true или false
    5. Для non-null ссылочной переменной a.equals(null) всегда false

    Метод toString в реализации класса Object возвращает имя класса + @ + hashcode




    */

}

class Computer {
    String model;
    int CPU_cores;

    public Computer(String model, int CPU_cores) {
        this.model = model;
        this.CPU_cores = CPU_cores;
    }

    @Override //<- перезапись метода equals() из Object
    public boolean equals(Object o) {
        if (o instanceof Computer) {
            Computer computer = (Computer) o;
            return computer.model.equals(model) && computer.CPU_cores == CPU_cores;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Computer model: " + model + " with CPU cores: " + CPU_cores;
    }




    public static void main(String[] args) {
        Computer c1 = new Computer("Acer", 4);
        Computer c2 = new Computer("ASUS", 8);
        Computer c3 = new Computer("Acer", 4);
        System.out.println(c1.equals(c2));
        System.out.println(c2.equals(c3));
        System.out.println(c1.equals(c3));
        System.out.println(c2);
    }
}