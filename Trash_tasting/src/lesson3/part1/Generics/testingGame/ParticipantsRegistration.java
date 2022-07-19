package lesson3.part1.Generics.testingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ParticipantsRegistration {
    private static List<Scoolar> scoolarTempList = new ArrayList<>();
    private static List<Student> studentTempList = new ArrayList<>();
    private static List<Emloyee> employeeTempList = new ArrayList<>();

    private static String inputName = "";
    private static int inputAge;

    public static List<Scoolar> getScoolarTempList() {
        return scoolarTempList;
    }

    public static List<Student> getStudentTempList() {
        return studentTempList;
    }

    public static List<Emloyee> getEmployeeTempList() {
        return employeeTempList;
    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void Registration() throws IOException {

        System.out.println("���:");
        while (true) {
            try {
                if (!(inputName = reader.readLine()).equals("")) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.err.print("�������� ���" + "\n");
        }
        System.out.println("�������:");

        while (true) {
            try {
                inputAge = Integer.parseInt(reader.readLine());
                if (inputAge >= 0) {
                    if (inputAge < 6) {
                        System.out.println("���� ���� ���� ��� ����)");
                    } else if (inputAge >= 6 && inputAge <= 17) {
                        scoolarTempList.add(new Scoolar(inputName, inputAge));
                    } else if (inputAge > 17 && inputAge <= 27) {
                        studentTempList.add(new Student(inputName, inputAge));
                    } else if (inputAge > 27) {
                        employeeTempList.add(new Emloyee(inputName, inputAge));
                    }
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.print("�������� �������, ������ ���" + "\n");
            }
        }

    }

    public static void infinityRegistration() throws IOException {
        System.out.println("��� ������ �������� �������... " + "\n" +
                "���� ���������� ������ ��� � ������� ������" + "\n");

        System.out.println("|��� Enter ��� ���������� � \"exit\" ��� \"�����\" ����� ��������� ���� �������|");
        while (true) {
            String ex = reader.readLine();
            if (ex.equals("exit") || ex.equals("�����") || ex.equals("Exit") || ex.equals("EXIT") || ex.equals("�����") || ex.equals("�����")) {
                System.out.println("���� ������� ��������!");
                break;
            } else {
                Registration();
            }
        }

    }


}
