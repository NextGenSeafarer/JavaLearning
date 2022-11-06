package lesson7.LambdaExpressions.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStream {
    public static void main(String[] args) {
        /*
        Parallel stream - использование ядер для нескольких Stream одновременно
        для улучшения производительности

        collection.parallelStream - метод создания либо Stream.parallel

        */

        List<Double> list = new ArrayList<>();
        Random random = new Random();
        for (double i = 100; i >= 1; i--) {
            list.add(random.nextDouble(1, 10));
        }


        double time3 = System.currentTimeMillis();
        double sumResult2 = list.stream().reduce(Double::sum).get();
        double time4 = System.currentTimeMillis();
        System.out.println("Normal stream sum timing: " + String.valueOf(time4 - time3));
        System.out.println("SUM RESULT NORMAL STREAM: " + sumResult2 + "\n--------------------------------------\n");


        double time1 = System.currentTimeMillis();
        double sumResult = list.parallelStream().reduce(Double::sum).get();
        double time2 = System.currentTimeMillis();
        System.out.println("Parallel stream sum timing: " + String.valueOf(time2 - time1));
        System.out.println("SUM RESULT PARALLEL STREAM: " + sumResult + "\n--------------------------------------\n");


        double time5 = System.currentTimeMillis();
        double divisionResult = list.stream().reduce((a, e) -> e / a).get();
        double time6 = System.currentTimeMillis();
        System.out.println("Normal stream division timing: " + String.valueOf(time6 - time5));
        System.out.println("DIVISION RESULT NORMAL STREAM: " + divisionResult + "\n--------------------------------------\n");


        double time7 = System.currentTimeMillis();
        double divisionResult2 = list.parallelStream().reduce((a, e) -> e / a).get();
        double time8 = System.currentTimeMillis();
        System.err.println("Parallel stream division timing: " + String.valueOf(time8 - time7));
        System.err.println("DIVISION RESULT PARALLEL STREAM: " + divisionResult2 + "\n--------------------------------------\n");
        System.err.println("Разница в результате деления между последовательным и параллельным стримом !!!!!\n" +
                "РАЗНИЦА В РЕЗУЛЬТАТАХ, НЕЛЬЗЯ ИСПОЛЬЗОВАТЬ, КОГДА НУЖЕН СТРОГИЙ ПОРЯДОК ВЫПОЛНЕНИЯ ОПЕРАЦИЙ\n" +
                "РАЗНИЦА В СКОРОСТИ ВЫПОЛНЕНИЯ, в моем случае почти в 3 раза для 100 миллионов элементов");


    }
}
