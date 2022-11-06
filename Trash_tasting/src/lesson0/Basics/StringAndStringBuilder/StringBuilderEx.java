package lesson0.Basics.StringAndStringBuilder;

public class StringBuilderEx {


    /*


    StringBuilder & StringBuffer - mutable классы, которые содержат в себе массив последовательности символов
    По сути то же самое что и String, но изменяемое.
    При изменении StringBuilder или StringBuffer - новый объект не создается, а меняется сам содержащийся массив символов.
    StringBuilder необходим для экономии ресурсов при работе с String подобными элементами, так как новой копии нет, всё
    хранится в одном единственном экземпляре, в то время как при изменении String будут создаваться все новые и новые String.
    Классическая размерность StringBuilder & StringBuffer - 16 символов, тогда как при создании в конструкторе, допустим
    StringBuilder sb = new StringBuilder("OK") - размерность будет 2 + 16, т.е. 18 символов
    Разница между StringBuilder и StringBuffer в том, что StringBuffer - потокобезопасный, поэтому он используется в
    мультипотоке, в то время как StringBuilder не имеет синхронизованных методов

    Официальные определения:
    StringBuilder - A mutable sequence of characters.
    This class provides an API compatible with StringBuffer,
    but with no guarantee of synchronization.
    This class is designed for use as a drop-in replacement for
    StringBuffer in places where the string buffer was being used by a single thread (as is generally the case).
    Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations.


    StringBuffer - A thread-safe, mutable sequence of characters.
    A string buffer is like a String, but can be modified.
    At any point in time it contains some particular sequence of characters,
    but the length and content of the sequence can be changed through certain method calls.

    В классах StringBuilder & StringBuffer не переопределен метод .equals() - поэтому что
    sb1.equals(sb2), что sb1 == sb2 будет одним и тем же, так как не переопределенный метод .equals() сравнивает
    ссылки, а не объекты!

    Интересные методы:
    .reverse()
    .delete()
    .chars() - возвращает IntStream

    Интересные факты:
    Если сравнивать StringBuilder sb = new StringBuilder("Privet") и StringBuilder sb2 = new StringBuilder("Privet")
    Просто через sb.equals(sb2) -> false
    Если же sb1.toString().equals(sb2.toString()) -> true, но по сути это сравнение 2 String, а не StringBuilder






    */

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("OK");
        System.out.println("StringBuilder capacity: " + sb.capacity());
        StringBuffer sb2 = new StringBuffer();
        System.out.println("StringBuffer capacity: " + sb2.capacity());
        //StringBuilder sb3 = new StringBuilder(null); // <- выбросит NullPointerException

    }

}
