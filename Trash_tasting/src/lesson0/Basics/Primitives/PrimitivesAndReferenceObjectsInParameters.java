package lesson0.Basics.Primitives;

public class PrimitivesAndReferenceObjectsInParameters {

/*

    В параметры метода можно передавать примитивные типы данных, которые в свою очередь передадут значение, которое
    они хранят
    При использовании же reference типов данных, передаваться будет КОПИЯ данного объекта, поэтому
    мы можем изменять поля нашего объекта, но не можем менять ссылки (references)


*/

}

class Car {
    String color;
    String engine;
    int doorsQuantity;

    Car(String color, String engine, int doorsQuantity) {
        this.color = color;
        this.engine = engine;
        this.doorsQuantity = doorsQuantity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", doorsQuantity=" + doorsQuantity +
                '}';
    }
}

class CarTest {

    public static void doorsQuantityChange(Car car, int quantityToChange) {
        car.doorsQuantity = quantityToChange;

    }

    public static void changeParameters(Car car1, Car car2) {
        String colorForSwap = car1.color;
        car1.color = car2.color;
        car2.color = colorForSwap;

    }

    public static void main(String[] args) {
        Car car1 = new Car("Black", "V8", 5);
        Car car2 = new Car("Red", "V12", 3);
        System.out.println("CAR1 ORIGINAL: -> " + car1.toString());
        System.out.println("CAR2 ORIGINAL: -> " + car2.toString());
        System.out.println();
        CarTest.doorsQuantityChange(car1, 10);
        System.out.println("CAR1 After DoorChange -> " + car1.toString());
        System.out.println();
        CarTest.changeParameters(car1, car2);
        System.out.println();
        System.out.println("CAR1 After ColorSwap -> " + car1.toString());
        System.out.println("CAR2 After ColorSwap -> " + car2.toString());

    }


}