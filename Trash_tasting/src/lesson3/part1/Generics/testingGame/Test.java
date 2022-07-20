package lesson3.part1.Generics.testingGame;

import java.io.IOException;



public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread thread = new Thread();
        thread.join();


        System.out.println("Привет Username!" + "\n");

//        AnnoyingCounter.count();

        ParticipantsRegistration.infinityRegistration();

        CreatingTeams.teamsSeparation();


    }
}
