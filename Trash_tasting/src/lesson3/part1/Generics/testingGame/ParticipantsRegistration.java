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

        System.out.println("Имя:");
        while (true) {
            try {
                if (!(inputName = reader.readLine()).equals("")) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.err.print("Неверное имя" + "\n");
        }
        System.out.println("Возраст:");

        while (true) {
            try {
                inputAge = Integer.parseInt(reader.readLine());
                if (inputAge >= 0) {
                    if (inputAge < 6) {
                        System.out.println("Тебе пока рано тут быть)");
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
                System.err.print("Неверный возраст, пробуй ещё" + "\n");
            }
        }

    }

    public static void infinityRegistration() throws IOException {
        System.out.println("Для начала создадим команду... " + "\n" +
                "Тебе необходимо ввести имя и возраст игрока" + "\n");

        System.out.println("|жми Enter для добавления и \"exit\" или \"выход\" чтобы закончить ввод игроков|");
        while (true) {
            String ex = reader.readLine();
            if (ex.equals("exit") || ex.equals("выход") || ex.equals("Exit") || ex.equals("EXIT") || ex.equals("Выход") || ex.equals("ВЫХОД")) {
                System.out.println("Ввод игроков закончен!");
                break;
            } else {
                Registration();
            }
        }

    }


}
