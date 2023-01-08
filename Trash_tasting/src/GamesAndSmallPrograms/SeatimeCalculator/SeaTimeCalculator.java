package GamesAndSmallPrograms.SeatimeCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeaTimeCalculator {
    static private List<LocalDate> listOfDates = new ArrayList<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int currentDate = 0; // <- to check is it beginning or end of the contract entry
    private static boolean continueIt = true; // <- to break the loop in inputDate() method if "E" or "e" entered


    public static void main(String[] args) {
        System.out.println("Hello %username%!");
        System.out.println("Welcome to sea service calculator");
        System.out.println("Entry format: DD/MM/YYYY or you can use \"now\" to get today date");
        System.out.println("Enter E to finalize\n");
        inputDate();
    }

    static void inputDate() {
        while (continueIt) {
            addDate();
        }
    }

    private static void addDate() { // <- Entry check / adding to ArrayList<LocalDate> listOfDates
        try {
            if (currentDate % 2 == 0) {
                System.out.println("Beginning of the contract:");
            }
            if (currentDate % 2 != 0) {
                System.out.println("End of the contract:");
            }
            LocalDate ld;
            String input = reader.readLine();
            if (input.equalsIgnoreCase("e")) { // <- to finish input
                totalCount(listOfDates);
                continueIt = false;
                return;
            }
            if (input.equalsIgnoreCase("now")) {
                ld = LocalDate.now();
            } else {
                int year = Integer.parseInt(input.substring(input.lastIndexOf("/") + 1));
                int month = Integer.parseInt(input.substring(input.indexOf("/") + 1, input.lastIndexOf("/")));
                int day = Integer.parseInt(input.substring(0, input.indexOf("/")));
                ld = LocalDate.of(year, month, day);
            }
            if (currentDate % 2 == 0) {
                currentDate++;
                listOfDates.add(ld);
                return;
            }
            if (ld.isAfter(listOfDates.get(currentDate - 1)) || ld.isEqual(listOfDates.get(currentDate - 1))) {
                currentDate++;
                listOfDates.add(ld);
            } else {
                System.err.println("End date is before start of the contract!");
            }
        } catch (IOException e) {
            System.out.println("Some banana happened!");
        } catch (DateTimeException e) {
            System.out.println("Wrong date format!");
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Wrong input data!");
        }
    }

    private static void totalCount(List<LocalDate> dates) { // <- Days counting by means of LocalDate class
        if (dates.size() == 1) { // <- in case when only the beginning of contract is entered
            System.out.println("Not enough information for count!");
            return;
        }
        if (dates.size() % 2 != 0) { // <- removing last beginning of the contract due to absent of it's finish
            listOfDates.remove(listOfDates.size() - 1);
        }
        int days = 0;
        for (int i = 0; i < dates.size(); i += 2) {
            LocalDate ldStart = dates.get(i);
            LocalDate ldFinish = dates.get(i + 1);

            /*
            I'm using while loop below because I need an exact number of days between dates, due to the calculation
            of sea time is counted 30 days per month to get full month, but for some month value is 31,
            class Period can be used with method .between(), but it will return a number of years, months and days
            between dates (where I don't really know which month is 31 or 30 or 28 or 27 days).
            The most precise way to count just days from ldStart to ldFinish by incrementing days;
            P.S.
            Method .between() is not including the last day,so I need to add it manually after calculations because
            days of contract are counted from and including day of contract starts and finish.
            */

            while (ldFinish.isAfter(ldStart) || ldFinish.isEqual(ldStart)) {
                days++;
                ldStart = ldStart.plusDays(1);
            }
        }
        System.out.println("Total days: " + days);
        int month = days / 30;
        int remainsDays = days % 30;
        System.err.println(month == 1 && remainsDays == 1 ? "You have: " + month + " month and " + remainsDays + " day" :
                month == 1 ? "You have: " + month + " month and " + remainsDays + " days" :
                        remainsDays == 1 ? "You have: " + month + " months and " + remainsDays + " day" :
                                "You have: " + month + " months and " + remainsDays + " days");

    }

}