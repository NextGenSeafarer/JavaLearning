package lesson3.part1.Generics.testingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreatingTeams {


    private static String name;
    private static String comand;

    public static String getName() {
        return name;
    }
    public void teamNaming() {
        System.out.println("Введите название команды: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                if (!(name = reader.readLine()).equals("")) {
                    break;
                }
                System.err.println("Имя команды не может быть пустым");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Кто будет состоять в данной команде?");
        System.out.println("\"Ш\" для школьников");
        System.out.println("\"С\" для студентов");
        System.out.println("\"Р\" для работяг");


        while (true) {
            try {
                if (!(comand = reader.readLine()).equals("")) {
                    if (comand.equals("ш") || comand.equals("Ш") || comand.equals("С") || comand.equals("с")
                            || comand.equals("Р") || comand.equals("р")) {
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.err.println("Может быть только Ш, С или Р");
        }
    }

    public void createTeam() {

        if (comand.equals("Ш") || comand.equals("ш")) {
            System.out.println("Создана команда шкильников с именем: " + name);
            System.out.println(ParticipantsRegistration.getScoolarTempList());
        }


        if (comand.equals("С") || comand.equals("с")) {
            System.out.println("Создана команда студенов с именем: " + name);
            System.out.println(ParticipantsRegistration.getStudentTempList());


        }
        if (comand.equals("Р") || comand.equals("р")) {
            System.out.println("Создана команда работяг с именем: " + name);
            System.out.println(ParticipantsRegistration.getEmployeeTempList());
        }

    }

    public static void teamsSeparation() {
        int totalParticipants = ParticipantsRegistration.getScoolarTempList().size() +
                ParticipantsRegistration.getStudentTempList().size() +
                ParticipantsRegistration.getEmployeeTempList().size();
        if (totalParticipants < 2 ){
            System.out.println("К сожалению для участия нужно хотя-бы 2 игрока!");
            System.out.println("Ждем Вас в следующий раз");
            return;
        }

        for (int i = 0; i < totalParticipants / 2; i++) {
            CreatingTeams creatingTeams = new CreatingTeams();
            creatingTeams.teamNaming();
            creatingTeams.createTeam();
        }

    }


}
