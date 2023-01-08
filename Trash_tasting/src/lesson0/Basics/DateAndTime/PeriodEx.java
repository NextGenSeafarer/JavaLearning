package lesson0.Basics.DateAndTime;

import java.time.LocalDate;
import java.time.Period;

public class PeriodEx {

    static void changeResp(LocalDate start, LocalDate finish, Period period) {
        LocalDate date = start;
        while (date.isBefore(finish)) {
            System.out.println("It's time to change!" + date);
            date = date.plus(period); // <- Период может быть Period.ofDays/Month/Weeks/Years
        }
    }

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2022, 9, 1);
        LocalDate finish = LocalDate.of(2023, 5, 31);
        Period period = Period.ofDays(22);
        PeriodEx.changeResp(start, finish, period);
    }


}
