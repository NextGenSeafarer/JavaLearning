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
        System.out.println("������� �������� �������: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                if (!(name = reader.readLine()).equals("")) {
                    break;
                }
                System.err.println("��� ������� �� ����� ���� ������");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("��� ����� �������� � ������ �������?");
        System.out.println("\"�\" ��� ����������");
        System.out.println("\"�\" ��� ���������");
        System.out.println("\"�\" ��� �������");


        while (true) {
            try {
                if (!(comand = reader.readLine()).equals("")) {
                    if (comand.equals("�") || comand.equals("�") || comand.equals("�") || comand.equals("�")
                            || comand.equals("�") || comand.equals("�")) {
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.err.println("����� ���� ������ �, � ��� �");
        }
    }

    public void createTeam() {

        if (comand.equals("�") || comand.equals("�")) {
            System.out.println("������� ������� ���������� � ������: " + name);
            System.out.println(ParticipantsRegistration.getScoolarTempList());
        }


        if (comand.equals("�") || comand.equals("�")) {
            System.out.println("������� ������� �������� � ������: " + name);
            System.out.println(ParticipantsRegistration.getStudentTempList());


        }
        if (comand.equals("�") || comand.equals("�")) {
            System.out.println("������� ������� ������� � ������: " + name);
            System.out.println(ParticipantsRegistration.getEmployeeTempList());
        }

    }

    public static void teamsSeparation() {
        int totalParticipants = ParticipantsRegistration.getScoolarTempList().size() +
                ParticipantsRegistration.getStudentTempList().size() +
                ParticipantsRegistration.getEmployeeTempList().size();
        if (totalParticipants < 2 ){
            System.out.println("� ��������� ��� ������� ����� ����-�� 2 ������!");
            System.out.println("���� ��� � ��������� ���");
            return;
        }

        for (int i = 0; i < totalParticipants / 2; i++) {
            CreatingTeams creatingTeams = new CreatingTeams();
            creatingTeams.teamNaming();
            creatingTeams.createTeam();
        }

    }


}
