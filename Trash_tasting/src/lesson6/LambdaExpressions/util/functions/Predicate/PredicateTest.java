package lesson6.LambdaExpressions.util.functions.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateTest {
    /*
            Predicate<T>  ------> класс для реализации: test(T t) - boolean
            по-сути может использоваться как простой фильтр
            Predicate <T> используется removeIf

     */
    void testStudents(ArrayList<StudentUtils> list, Predicate<StudentUtils> predicate) {
        for (StudentUtils student : list) {
            if (predicate.test(student)) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<StudentUtils> listOfStudents = new ArrayList<>();
        StudentUtils student1 = new StudentUtils("Unit1", 26, 'm', 9.5);
        StudentUtils student2 = new StudentUtils("Unit2", 19, 'm', 8.8);
        StudentUtils student3 = new StudentUtils("Unit3", 27, 'f', 7.3);
        StudentUtils student4 = new StudentUtils("Unit4", 33, 'm', 5.0);
        StudentUtils student5 = new StudentUtils("Unit5", 22, 'f', 6.7);
        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);
        listOfStudents.add(student4);
        listOfStudents.add(student5);


        PredicateTest predicateTest = new PredicateTest();
        System.out.println("По возрасту\n");
        predicateTest.testStudents(listOfStudents, student -> student.age > 23); // лямбда выражения для фильтра по возрасту с помощью Predicate <T>
        System.out.println("------------------------------------\n");

        // напишем пару фильтров для листа студентов через Predicate
        Predicate<StudentUtils> studentAgeCheck = student -> student.age > 25; // возраст больше 25
        Predicate<StudentUtils> studentAvGradeCheck = student -> student.avGrade > 8; // средняя оценка больше 8


        //их можно проверять вместе с помощью and
        System.out.println("По возрасту и оценке(и то и другое должно быть true)\n");
        predicateTest.testStudents(listOfStudents, studentAgeCheck.and(studentAvGradeCheck)); //проверка по возрасту и оценке
        System.out.println("------------------------------------\n");


        //их можно проверять вместе с помощью or (или то или другое)
        System.out.println("По возрасту и оценке(одно из условий или то или то должно быть true)\n");
        predicateTest.testStudents(listOfStudents, studentAgeCheck.or(studentAvGradeCheck)); // если одно из двух удовлетворяет
        System.out.println("------------------------------------\n");

        // их можно проверять с помощью negate - противоположность условия, допустим как в первой проверке, возраст больше 25
        // чтобы не писать проверку на возраст меньше 25 можно выполнить метод .negate
        System.out.println("По возрасту меньше 25 лет (negate method)\n");
        predicateTest.testStudents(listOfStudents, studentAgeCheck.negate()); //проверка по возрасту меньше 25
        System.out.println("------------------------------------\n");


    }


}

class StudentUtils {
    String name;
    int age;
    char sex;
    double avGrade;

    public StudentUtils(String name, int age, char sex, double avGrade) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.avGrade = avGrade;
    }

    @Override
    public String toString() {
        return "StudentUtils{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", avGrade=" + avGrade +
                '}';
    }
}
