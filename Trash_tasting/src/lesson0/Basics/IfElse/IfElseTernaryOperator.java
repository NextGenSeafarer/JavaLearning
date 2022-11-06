package lesson0.Basics.IfElse;

public class IfElseTernaryOperator {

    /*

    Существующие конструкции:

    if(boolean); <- ничего не произойдет, просто сравнение
    ------------
    if(boolean) <- if с пустым телом
    {
    }
    ------------
    if(boolean){} <- if с одним else
    else{}
    ------------

    if(boolean){ <- if с вложенным if (nested if)
    if(boolean){}
    else{}
    }
    else{}

    Сравнение == применимо для примитивных типов данных и сравнения ссылок reference type данных
    Тернарный оператор (от слова 3) выглядит как:
    (boolean) ? first : second

    */
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int max = (a > b) ? a : b; // <- применение тернарного оператора
        String first = new String("Hello");
        String second = new String("Hello");
        System.out.println("Сравниваю 2 ссылки first & second через == " + "\"" + (first == second) + "\"");
        System.out.println("Сравниваю 2 строки (объекты типа String) first & second через .equals() " + "\"" + first.equals(second) + "\"");

        String one = "one";
        String oneO = "one";
        System.out.println(one == oneO); // <- возвращает true, т.к. ссылка берется из String Pool


    }


}
