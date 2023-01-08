package lesson0.Basics.Operators;

public class Operators {

    /*


    Существуют операторы:
    Арифметические (arithmetic):        + - * /     +=  -=  *=  /=  ++  --  %
    Присваивания (assignment)           =
    Логические (logical)                >    <   >=  <=  ==  !=  !
    Сравнения (relational)              &&  ||   &   |    ^

    Операторы сравнения && (AND) || (OR) - short circuit operators, т.е. они не будут проверять остальное выражение справа
    если первое выражение false, применимы ТОЛЬКО ДЛЯ ПЕРЕМЕННЫХ ТИПА BOOLEAN

    & и | (одинарные) проверят все условие и выполнят действие вне зависимости от первого результата
    т.е.
    int a = 5;
    int b = 6;
    int c = 0;

    if(a>b & ++c < b) если а больше b (что уже false), но выражение продолжит проверку и прибавит к c единицу, а затем сравнит с b
    Эти операторы подходят для цифр, т.е (побитовые операции)
    0 - false
    1 - true

    int a = 10;     в бинарном виде: 1010
    int b = 7;      в бинарном виде: 0111
                              тогда: 1&0 (==0) 0&1 (==0) 1&1 (==1) 0&1 (==0)
                              новое число a & b = 0010 (будет 2 в десятичной системе)
                              а для |, т.е. a|b = 1|0 (==1) 0|1 (==1) 1|1 (==1) 0|1 (==1)
                              новое число для a | b = 1111 (будет 15)

    ^ - возвращает true, если только 1 выражение из всех является true!


    */


    public static void main(String[] args) {

        // prefix and suffix:
        // если ++i, тогда сначала изменяется в памяти, затем остальное
        // если i++, тогда все остальное, потом изменение в памяти

        int first = 0;
        int sec = 2;
        int result1 = first + sec++;
        System.out.println("result1 = " + result1);
        // здесь сначала выполняется сложение, потом прибавляется единица к sec


        System.out.println("\n---------------------------------------------------------------------------\n");

        int third = 5;
        int fourth = 3;
        int result2 = third + ++fourth;
        System.out.println("result2 = " + result2);
        // здесь сначала выполнится прибавка, а затем сложение

        System.out.println("\n---------------------------------------------------------------------------\n");


        //short circuit:

        int a = 5;
        int b = 10;
        int c = 0;

        System.out.println(a > b && c == b++);
        System.out.println("c = " + c); // т.е. тут правая часть выражения даже не проверяется, ибо первое условие false

        System.out.println("\n---------------------------------------------------------------------------\n");


    }
}