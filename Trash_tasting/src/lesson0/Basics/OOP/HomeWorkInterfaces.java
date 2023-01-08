package lesson0.Basics.OOP;

public class HomeWorkInterfaces {

    public static void main(String[] args) {
        SwordFish swordFish = new SwordFish("Vitalya");
        System.out.println("Our swordFish we call: " + swordFish.name);
        swordFish.eat();
        swordFish.sleep();
        swordFish.swim();
        System.out.println("--------------------------------------------");
        Speakable penguin = new Penguin("Vasya");
        penguin.speak();
        System.out.println("--------------------------------------------");
        Animal lion = new Lion("Nikolay");
        System.out.println("Our lion name is: " + lion.name);
        lion.eat();
        lion.sleep();
        System.out.println("--------------------------------------------");
        Mammal lion2 = new Lion("Mark");
        System.out.println("Our lion2 name is: " + lion.name);
        lion2.run();
        lion2.eat();
        lion2.sleep();
        lion2.speak();



    }

}

abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract void eat();

    abstract void sleep();
}

abstract class Fish extends Animal {
    public Fish(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void sleep() {
        System.out.println("It is always interesting to see how fishes sleep!");
    }

    abstract void swim();
}

abstract class Bird extends Animal implements Speakable {

    public Bird(String name) {
        super(name);
        this.name = name;
    }

    abstract void fly();

    @Override
    public void speak() {
        System.out.println(name + " sings");
    }
}

abstract class Mammal extends Animal implements Speakable {
    public Mammal(String name) {
        super(name);
        this.name = name;
    }
    abstract void run();
}

class SwordFish extends Fish {
    public SwordFish(String name) {
        super(name);
        this.name = name;
    }

    @Override
    void eat() {
        System.out.println("Swordfish isn't hunter, it eats only veges");
    }

    @Override
    void swim() {
        System.out.println("Swordfish is fast and beautiful");
    }
}

class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
        this.name = name;
    }

    @Override
    void eat() {
        System.out.println("Penguin likes to eat fish!");
    }

    @Override
    void sleep() {
        System.out.println("Penguins are sleeping near each other");
    }

    @Override
    void fly() {
        System.out.println("Penguins doesn't know how to fly!");
    }

    @Override
    public void speak() {
        System.out.println("Penguins are not a good singers");
    }
}

class Lion extends Mammal {
    public Lion(String name) {
        super(name);
        this.name = name;
    }

    @Override
    void eat() {
        System.out.println("Lion likes fresh meat");
    }

    @Override
    void sleep() {
        System.out.println("Lion is almost always sleeps");
    }

    @Override
    void run() {
        System.out.println("Lion is fast but not enough");
    }
}


interface Speakable {
    default void speak() {
        System.out.println("somebody speaks");
    }
}