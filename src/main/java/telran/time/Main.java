package telran.time;

import java.time.LocalDate;
import java.time.Month;

record MonthYear(int month, int year){
}

public class Main {
    public static void main(String[] args) {
        try {
            MonthYear monthyear = getMonthYear(args);
            printCalendar(monthyear);  
        } catch (RuntimeException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
          
    }

    private static void printCalendar(MonthYear monthYear) {
        printTitle(monthYear);
        printWeekDays();
        printDates(monthYear);
        
    }

    private static MonthYear getMonthYear(String[] args) throws Exception {
        if (args.length != 2) {
            throw new Exception("Please provide month and year as arguments.");
        }
        try {
            int month = Integer.parseInt(args[0]);
            int year = Integer.parseInt(args[1]);
            if (month < 1 || month > 12) {
                throw new Exception("Month must be between 1 and 12.");
            }
            return new MonthYear(month, year);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid number format for month or year.");
        }
    }

    private static void printTitle(MonthYear monthYear) {
        String monthName = Month.of(monthYear.month()).name();
        System.out.println("    "+ monthName + " " + monthYear.year());
    }

    private static void printWeekDays() {
        System.out.println("Mo Tu We Th Fr Sa Su");
    }

    private static void printDates(MonthYear monthYear) {
        int firstDayOfWeek = getFirstDayOfWeek(monthYear);
        int lastDayOfMonth = getLastDayOfMonth(monthYear);
        int offset = getOffSet(firstDayOfWeek);

        for (int i = 0; i < offset; i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= lastDayOfMonth; day++) {
            System.out.printf("%2d ", day);
            if ((offset + day) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static int getFirstDayOfWeek(MonthYear monthYear){
        LocalDate firstDay = LocalDate.of(monthYear.year(), monthYear.month(), 1);
        return firstDay.getDayOfWeek().getValue();
    }

    private static int getOffSet(int firstWeekDay){
        return firstWeekDay-1 % 7;
    }

    private static int getLastDayOfMonth(MonthYear monthYear) {
        LocalDate lastDay = LocalDate.of(monthYear.year(), monthYear.month(), 1).withDayOfMonth(1).plusMonths(1).minusDays(1);
        return lastDay.getDayOfMonth();
    }
}