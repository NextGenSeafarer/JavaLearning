package lesson4.Collections.Stack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {

/*
     Stack - устаревший вид коллекций, такой же как и Vector, также является Synchronized.
     Использует принцип FILO - first in, last out.
     Т.е. как тарелки на столе - первая, положенная на стол тарелка, будет first in, но чтобы её достать - надо будет
     убрать все сверху, поэтому last out.

     Не рекомендуется к использованию.

     Методы:
     .push - добавляет на верх Stack (т.е. последним элементом)
     .pop - берет самый верхни элемент и тут же удаляет его
     .peek - просто берет самый верхний элемент
     .isEmpty - проверяет на наличие элементов в Stack

     Остальные методы типа get, set, remove такие же, как у других коллекций.
*/

        Stack<String> stringStack = new Stack<>();
        stringStack.push("Ilia");
        stringStack.push("Kirill");
        stringStack.push("Bonya");
        System.out.println(stringStack);
        stringStack.pop(); // - тут Bonya была удалена
        System.out.println(stringStack);
        System.out.println(stringStack.peek()); // - тут берется самый верхний элемент коллекции
    }
}
