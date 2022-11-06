package lesson7.LambdaExpressions.Streams;

public class StreamMethodChaining {

/*

    Вызов нескольких методов подряд { methodChaining }
    lazy (intermediate) methods:
    - map
    - filter
    - sorted
    - distinct - вывод уникальных элементов Stream
    - peek - принимает Consumer, необходим для промежуточных выводов, проверок
    - flatMap - работа с элементами элементов коллекции
        Например : List<Faculty> faculty -> факультет студентов физиков -> студенты самого факультета
        faculty.stream().flatMap(faculty -> faculty.getStudentsOnFaculty().stream()).forEach(stud -> sout(stud.getName)));
    - limit - ограничение количества элементов в Stream
    - skip - пропускает первые n элементов в Stream
    - mapToInt - преобразование любого Stream в Integer (необходим .boxed()) для конвертации из int в Integer
    тоже самое для mapToDouble ||| методы для Int Stream :  .sum(), average(), .min(), .max()


    eager (terminated) methods:
    - forEach
    - reduce
    -           collect
          /                \
     grouping by        partitioningBy
    возвращает Map    возвращает map и разделяет элементы по условию на true и false

    - findFirst - находит первый элемент и возвращает Optional<T>, поэтому нужно применять .get()
    - min - возвращает минимальный элемент (если это generics - нужно прописать comparator)
    - max - возвращает максимальный элемент (если это generics - нужно прописать comparator)

    - count - выводит количество элементов в Stream


    somewhereBetween
     Stream.concat
    - concat - вызывается на Stream и возвращает Stream, но после него ничего нельзя вызвать




*/


}
