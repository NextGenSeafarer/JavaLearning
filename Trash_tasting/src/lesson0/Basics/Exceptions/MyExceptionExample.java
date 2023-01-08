package lesson0.Basics.Exceptions;

public class MyExceptionExample {

    static void checkCondition(int RPM, int exhaustTemperature, boolean isOMDActivated) throws EngineShutDown {
        if (RPM > 616) {
            throw new EngineShutDown("Engine overspeed activated");
        }
        if (isOMDActivated) {
            throw new EngineShutDown("Engine tripped by OMD");
        }
        if (exhaustTemperature > 600) {
            throw new EngineSlowDown("Too high exhaust temperature!");
        }
    }

    public static void main(String... args) {
        try {
            checkCondition(515, 500, true);
        } catch (EngineShutDown e) {
            System.out.println("Engine got some troubles: " + e.getMessage());
            return;
        } finally {
            System.out.println("All parameters are recorded");
        }
        System.out.println("Engine running ok");
    }


}

class EngineShutDown extends Exception {
    EngineShutDown() {
    }

    EngineShutDown(String message) {
        super(message); // <- передаем сообщение в супер класс (класс Exception)
    }

}

class EngineSlowDown extends RuntimeException {
    EngineSlowDown() {
    }

    EngineSlowDown(String message) {
        super(message);
    }
}
