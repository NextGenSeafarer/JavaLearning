package lesson6.LambdaExpressions.util.functions.Supplier;

import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierTest {

    /*
    Supplier нужен для того, чтобы поставлять объекты, обладает единственным абстрактным методом (а значит является
    функциональным интерфейсом), методом get.
    По сути я могу передавать любой generic объект, будь то Car или String, Integer или что угодно в Supplier, а он будет
    возвращать эти объекты.
    За счет этого я могу передавать Supplier объекты, а затем возвращать их же методом .get
    Ниже создается метод createThreeCars, который принимает carSupplier, и записывает объекты типа Car в ArrayList
    При этом неясно какие именно машины будут записаны, поэтому через лямбда выражение я могу задать параметры передаваемых
    машин.

     */

    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier) {
        ArrayList<Car> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(carSupplier.get());
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Car> ourCars = createThreeCars(() -> new Car("Nissan X-Trail", "White", 2.0));
        System.out.println("My cars:\n" + ourCars);
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
