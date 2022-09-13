package lesson6.LambdaExpressions.util.functions.Consumer;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ConsumerTest {

    /*
    Consumer - противоположность Supplier, ничего не возвращает, а только работает с объектами
    forEach - метод для Consumer!
     */

    public static void changeCar(Car car, Consumer<Car> carConsumer) {
        carConsumer.accept(car);
    }

    public static void main(String[] args) {
        ArrayList<Car> list = new ArrayList<>();
        list.add(new Car("Nissan X-Trail", "White", 2.4));
        list.add(new Car("Nissan X-Trail", "White", 2.4));
        list.add(new Car("Nissan X-Trail", "White", 2.4));
        changeCar(list.get(0), car -> {
            car.color = "Orange";
            car.engine = 5.6;
            car.model = "Skyline";
            System.out.println("Upgraded car in list.get(0): " + car);
        });
        // здесь идет работа с первым объектом в коллекции list (с первой машиной)
        // Consumer принимает первую машину, затем меняет цвет, мотор и модель в списке
        // ничего не возвращает.
        System.out.println(list);

    }


}

class Car {
    String model;
    String color;
    double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}
