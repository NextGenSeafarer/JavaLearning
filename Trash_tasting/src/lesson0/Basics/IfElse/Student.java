package lesson0.Basics.IfElse;

public class Student {
    String name;
    int course;
    double avgGrade;

    public Student(String name, int course, double avgGrade) {
        this.name = name;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public String toString() {
        return "Student: " + "name: " + name + ", course: " + course + ", avgGrade: " + avgGrade;
    }
}

class StudentTest {

    public void compareStudents(Student st1, Student st2) {
        if (st1.name.equals(st2.name) && st1.course == st2.course && st1.avgGrade == st2.avgGrade) {
            System.out.println("Students are the same");
        }
        else {
            System.out.println("Students are not the same");
        }
    }

    public void compareStudentsPrecise(Student st1, Student st2) {
        if (st1.name.equals(st2.name)) {
            if (st1.course == st2.course) {
                if (st1.avgGrade == st2.avgGrade) {
                    System.out.println("Students are completely same!");
                } else {
                    System.out.println("Students are different in avgGrade!");
                }
            } else {
                System.out.println("Students are different in courses");
            }
        } else {
            System.out.println("Students different in names!");
        }
    }

    public static void main(String[] args) {
        StudentTest studentTest = new StudentTest();
        Student st1 = new Student("Ilia", 5, 9.5);
        Student st2 = new Student("Ilia5", 5, 9.5);
        studentTest.compareStudents(st1,st2);
        System.out.println("-------------------");
        studentTest.compareStudentsPrecise(st1,st2);





    }

}
