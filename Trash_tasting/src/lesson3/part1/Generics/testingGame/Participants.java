package lesson3.part1.Generics.testingGame;

public abstract class Participants {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Имя: " + name +
                ", Возраст: " + age;
    }

    public Participants(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
