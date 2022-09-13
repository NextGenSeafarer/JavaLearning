package lesson4.Collections.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class dequeueExample {
    /*
    Dequeue - двунаправленная очередь, в которой работают правила как FILO так и FIFO
    Можно добавлять элементы как в начало очереди, так и в конец, также тут присутствуют двойные методы
    В зависимости от назначения и возможностей многопоточности (то же самое что и простой Queue)
    */
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.addFirst(2);
        deque.addLast(5);
        //в данный момент deque будет 2 1 5
        System.out.println(deque);

        deque.offer(9);
        deque.offerFirst(0);
        deque.offerLast(99);
        // в этот момент deque будет 0 2 1 5 9 99
        System.out.println(deque);


        deque.remove(); // удаление первого (либо конкретного элемента)
        deque.removeFirst(); // удаление первого элемента
        deque.removeLast(); // удаление последнего элемента

        deque.poll(); // также удаление, но уже в многопотоке и без выбрасывания исключений
        deque.pollFirst();
        deque.pollLast();

        deque.getFirst(); // получение первого элемента
        deque.getLast(); // получение последнего

        deque.peek(); // получение первого в многопотоке
        deque.peekFirst(); // получение первого в многопотоке
        deque.peekLast(); // получение последнего в многопотоке



    }
}
