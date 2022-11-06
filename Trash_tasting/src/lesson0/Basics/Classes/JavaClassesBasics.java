package lesson0.Basics.Classes;

public class JavaClassesBasics {

    /*

    Class - это чертеж, например дома
    Object - это реальный объект, дом

    Примитивные типы данных (их 8) создавались по типу: int a = 10;
    Т.е. переменная a будет хранить в себе значение 10.

    Ссылочные типы данных (их бесконечно много) создаются по типу:
    SomeClass oneClass = new SomeClass();

    SomeClass - по аналогии с примитивами - это тип данных, OneClass - это переменная, которая хранит ссылку на объект
    new SomeClass() - что само по себе является конструктором, главной задачей которого является создание объекта.

    АДРЕСС НА ОБЪЕКТ ХРАНИТСЯ В ШЕСТНАДЦАТЕРИЧНОЙ ФОРМЕ

    Класс может содержать переменные, Instance variables - инстансы класса - есть его поля.

    Любой класс устроен так:

    package
    public class SomeClass {
    может содержать, а может и нет main
    }
    Если в файле 2 и более класса, тогда файл должен называться точно также как его public Class, если public классов нет,
    тогда файл должен называться как один из присутствующих в нем классов, если исполнять файл .javac из командной строки -
    и в файле будет больше чем 1 main method, исполнится тот, который public

    */

}

class StudentExample {
    int id;
    String name;
    String surname;
    int course;
    double AVGEconomicsMark;
    double AVGMathematicsMark;
    double AGEEnglishMark;


}

class StudentTest {
    public static void main(String[] args) {

        StudentExample student1 = new StudentExample();
        StudentExample student2 = new StudentExample();
        StudentExample student3 = new StudentExample();
        student1.AVGEconomicsMark = 3.4;
        student1.AVGMathematicsMark = 3.9;
        student1.AGEEnglishMark = 4.4;

        student2.AVGEconomicsMark = 4.1;
        student2.AVGMathematicsMark = 4.9;
        student2.AGEEnglishMark = 4.8;

        student3.AVGEconomicsMark = 4.9;
        student3.AVGMathematicsMark = 5;
        student3.AGEEnglishMark = 5;

        System.out.println("Student1 AVG marks: " + (student1.AVGMathematicsMark + student1.AGEEnglishMark + student1.AVGEconomicsMark)/3);
        System.out.println("Student2 AVG marks: " + (student2.AVGMathematicsMark + student2.AGEEnglishMark + student2.AVGEconomicsMark)/3);
        System.out.println("Student3 AVG marks: " + (student3.AVGMathematicsMark + student3.AGEEnglishMark + student3.AVGEconomicsMark)/3);
    }
}