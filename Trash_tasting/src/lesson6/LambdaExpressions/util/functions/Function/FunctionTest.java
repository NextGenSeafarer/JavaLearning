package lesson6.LambdaExpressions.util.functions.Function;

import java.util.ArrayList;
import java.util.function.Function;

public class FunctionTest {


    /*

    Функциональный интерфейс Function нужен в случае, когда на входе передается один тип данных, а возвращается другой
    Например если я хочу передавать студента, а возвращать средний возраст.

    */

    private static double checkSomething(ArrayList<Student> list, Function<Student, Double> function) {
        double result = 0;
        for (Student st : list) {
            result += function.apply(st);
        }
        result = result / list.size();
        return result;
    }
    // В данном методе мы пишем логику подсчета среднего арифметического ЧЕГО-ТО, а чего именно, мы передадим
    // в lambda выражении далее, метод .apply принимает в себя st (Student), но возвращает Double
    // т.е. R apply(T t), R - возвращает, T t - принимает


    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student student1 = new Student("Unit1", 26, 'm', 9.5);
        Student student2 = new Student("Unit2", 19, 'm', 8.8);
        Student student3 = new Student("Unit3", 27, 'f', 7.3);
        Student student4 = new Student("Unit4", 33, 'm', 5.0);
        Student student5 = new Student("Unit5", 22, 'f', 6.7);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);

        // Function<Student, Double> function  = student -> student.avGrade;
        // лямбда функция для подсчета средней оценки, которая принимает в себя студента, а возвращает double
        list.forEach(student -> System.out.println(student));
        System.out.println("<------------------------------------------------>\n");

        System.out.println("AVG grade: " + checkSomething(list, student -> student.avGrade)); // вывод средней оценки студентов
        // сам метод, в котором мы уточняем какое именно поле класса Student должно возвращать заданный тип Double

        System.out.println("AVG age: " + checkSomething(list, student -> (double) student.age)); // вывод среднего возраста
    }
}

class Student {
    String name;
    int age;
    char sex;
    double avGrade;

    public Student(String name, int age, char sex, double avGrade) {
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