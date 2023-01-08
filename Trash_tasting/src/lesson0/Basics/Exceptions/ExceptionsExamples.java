package lesson0.Basics.Exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionsExamples {
    /*

    Exceptions иерархия

                    Object
                  Throwable
         Exceptions         Error
       /           \
Runtime Exception   IOExceptions(etc.)-проверяемые




        Error - ошибка, которая относится к JVM, обработка или выбрасывание Errors - не совсем верное решение
        Самый банальный пример error - это StackOverflow, можно вызвать рекурсивным методом

        public static void abc(){
        sout("Recursion");
        abc(); <- вот здесь мы вызываем сам метод внутри себя, т.е. рекурсивно
        }
        psmv{
        abc(); <- будет выполняться до момента StackOverflow
        }

        try - catch - finally
        try with resources

        Если в try / catch / finally есть return statements, тогда всегда возвращаться будет из finally, т.к. он выполняется всегда
        Если return statement в catch блоке - примитивный тип данных, то в finally блоке он не может быть изменен, если же reference
        type - тогда может быть изменен в finally block (пример с int и StringBuilder в качестве возвращаемого значения)

        RunTimeExceptions:

        ArrayOutOfBoundsException - выход за рамки массива
        IndexOutOfBoundsException - то же самое для коллекций (это супер класс для ArrayOutOfBoundsException)
        ClassCastException - часто бывает при не правильном downcast (только при IS A отношениях)
        ArithmeticException - при делении на 0
        IllegalArgumentException
        IllegalStateException
        NullPointerException - String s = null; s.length()
        NumberFormatException - Integer.parseInt(44OBJECT);

        Errors:

        ExceptionInInitializerError - все, что связанно с static инициализаторами, методами или переменными. static String s = null; s.length()
        StackOverflowError - рекурсия (virtual machine error)
        OutOfMemoryError - (virtual machine error)
        NoClassDefFoundError - не найдет класс в runtime

        Перезаписанные методы могут выбрасывать либо точно такие же Exceptions или же их child классов, потому что
        При вызове метода будет использован runtime binding, а мы уже определили в try - catch блоке исключение, либо же выбросили его сами в методе
        Однако это относится только к Checked exceptions, т.е. перезаписанный метод может выбрасывать unchecked exceptions какие угодно
        В Overloaded methods без разницы




    */


}

class Test1 {
    public static void main(String[] args) {


        File filePath = new File("movablePart.txt");
        System.out.println("Path created");
        try {
            FileInputStream fis = new FileInputStream(filePath);
            System.out.println("Code1..."); //<- если будет поймано исключение выше, то этот код не будет выполнен
            System.out.println("Code2..."); //<- если будет поймано исключение выше, то этот код не будет выполнен
            System.out.println("Code3..."); //<- если будет поймано исключение выше, то этот код не будет выполнен
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } finally {
            System.out.println("ITs finally block");
        }
    }

}
