package lesson0.Basics.DateAndTime;

import java.time.*;

public class MethodsDateAndTime {

    public static void main(String[] args) {
        System.out.println(LocalDate.now()); // <- только год, месяц, число
        System.out.println(LocalTime.now()); // <- только часы, минуты, секунды, наносекунды
        System.out.println(LocalDateTime.now()); // <- все вместе
        LocalDate ld = LocalDate.of(2022, 12, 7);
        LocalDate ld2 = LocalDate.of(2022, Month.DECEMBER, 7); // <- второй вариант создания даты
        System.out.println("ld has parameters: " + ld);
        System.out.println("ld2 has parameters: " + ld2);
        // При некорректном вводе аргумента выбросится DateTimeException
        ld.plusDays(5);
        ld.minusDays(5);
        ld.plusWeeks(2);
        ld.minusWeeks(3);
        LocalTime lt = LocalTime.now();
        System.out.println(lt.plusSeconds(5000).minusMinutes(3).plusHours(6));
        ld.isAfter(ld2); //<- сравнение дат
        lt.isBefore(LocalTime.now()); // <- сравнение времени

    }


}
