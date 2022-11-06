package lesson0.Basics.StringAndStringBuilder;

public class StringInf {

    /*

    Class String - immutable!
    Class String используется для хранения символов в массиве.
    Т.к. хранение символов производится в private final массиве - (private final byte[] value) их изменение невозможно, поэтому при работе
    со String в некоторых случаях, когда производится изменение строки - создается новый объект.
    String abc = new String ("abc");
    создается новый объект типа String, который хранит ссылку на char массив, содержащий ['a', 'b', 'c']
    класс String хранится в пакете java.lang.


    private final char[] value

    Immutable потому что:
    - String хранит значение в private массиве, сам массив имеет фиксированную длину, доступ к нему может быть осуществлен только из самого класса String
    - String хранит значение в final массиве, его инициализация может быть только один раз!
    Из-за private мы не можем получить доступ к массиву и поменять его, из-за final мы не можем поменять ссылку на другой объект
    - Ни один из методов класса String не изменяет внутренность массива!

      String str = "abc";
      is equivalent to:
      char data[] = {'a', 'b', 'c'};
      String str = new String(data);

      --------------------------------------------------------------------------------------------------------------------------------------------------
      String Constant Pool - место хранения строк, которые используются во время работы программы, для экономии места.

      String a = "privet";
      String b = "privet";

      Логика:
      String pool пустой.
      "privet" существует в String Pool?-> false -> добавляем в String pool
      Теперь переменная a ссылается на "privet" из String pool
      Теперь проверка b, String pool содержит "privet" ?-> true -> теперь и b ссылается на тот же объект из String Pool
      Так будет для всех объектов, которые не используют ключевое слово new при создании строки

      String str = new String("privet"); <- новый объект, со своей ссылкой, независимо от того есть ли в String pool такая строка
      String str1 = new String("privet"); <- новый объект, со своей ссылкой, независимо от того есть ли в String pool такая строка
      String str2 = new String("privet"); <- новый объект, со своей ссылкой, независимо от того есть ли в String pool такая строка

      При использовании методов класса String, если исходная строка изменяется, тогда меняется и ссылка на объект, т.к. создается
      новый объект

      Интересные методы:
      strip() - удаляет все пробелы в начале и в конце строчки
      stripLeading() - удаляет все пробелы в начале строчки
      stripTrailing() - удаляет все пробелы в конце строчки


    */


    public static void main(String[] args) {

        String a = "abc";
        String b = "abc";
        String c = "abc";

        System.out.println("a, b, c ссылаются на один объект из String pool? : " + (a == b && b == c && a == c));

        System.out.println("abc, переданный в println ссылается на объект, на который ссылается и a? : " + ("abc" == a));

        System.out.println("a.trim() == b.trim() ? : " + (a.trim() == b.trim()) + " <- потому что не меняют объекты");

        String d = "abc ";
        System.out.println("d.trim() == a.trim() ? : " + (a.trim() == d.trim()) + " <- потому что d.trim() из  \"abc \" делает \"abc\", создается новый объект");

        String e = new String("abc");
        String f = new String("abc");
        System.out.println("e и f созданы через конструктор с использованием new, при этом значения одинаковые, но ссылки равны? -> " + (e == f));

        String g = "poka";
        String h = "poka";
        System.out.println("Оба объекта одинаковые и над ними выполняются одинаковые операции (ИЗМЕНЕНЫЕ СТРОКИ ОТЛИЧАЮТСЯ ОТ ОРИГИНАЛОВ), ссылки на них одинаковые? -> "
                + (g.substring(0, 2) == h.substring(0, 2)));

        System.out.println("Оба объекта одинаковые и над ними выполняются одинаковые операции (ИЗМЕНЕНЫЕ СТРОКИ НЕ ОТЛИЧАЮТСЯ ОТ ОРИГИНАЛОВ), ссылки на них одинаковые? -> "
                + (g.replace('V', 'L') == h.replace('V', 'L')));
        System.out.println("-----------------------------------------------------------------------------");

        String i = "_poka";
        String j = i.replace("_", "");
        System.out.println(i.replace("_", "") == g);
        System.out.println(j == g);
        System.out.println("-----------------------------------------------------------------------------");

        System.out.println("String Stream: method .lines()");
        String l = "1\n2\n3";
        System.out.println(l);
        l.lines().forEach(x -> System.out.println(x.repeat(10)));

        String s = "a";
        switch (s) {
            case "a", "l" -> System.out.println("a");
            case "b" -> System.out.println("b");
        }


    }
}
