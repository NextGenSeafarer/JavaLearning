package lesson0.Basics.Exceptions;

public class ExceptionsHW {


    public static void main(String[] args) {

        Tiger tiger = new Tiger();
        tiger.eat("meat");
        try {
            tiger.drink("water");
            try {
                tiger.drink("beer");
            } catch (NotWaterException e) {
                System.out.println("Inner catch: " + e.getMessage());
            } finally {
                System.out.println("It's inner finally block");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}

class NotMeatException extends RuntimeException {

    NotMeatException(String message) {
        super(message);
    }
}

class NotWaterException extends Exception {

    NotWaterException(String message) {
        super(message);
    }
}

class Tiger {
    void eat(String food) {
        if (!food.equalsIgnoreCase("meat")) {
            throw new NotMeatException("Tiger is not eating : " + food);
        }
        System.out.println("Tiger is eating meat!");
    }

    void drink(String drink) throws NotWaterException {
        if (!drink.equalsIgnoreCase("water")) {
            throw new NotWaterException("Tiger is not drinking : " + drink);
        }
        System.out.println("Tiger is drinking water!");
    }
}