package lesson3.part1.Generics.testingGame;

public class AnnoyingCounter {
    public  static void count () {
        System.out.println("секундОчку" );
        for (int i = 1; i < 4 ; i++) {
            try {
                System.out.println(".".repeat(i));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
