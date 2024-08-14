package telran.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

record MonthYear(int month, int year, int weekStartDay){
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
        printWeekDays(monthYear);
        printDates(monthYear);
        
    }

    private static MonthYear getMonthYear(String[] args) throws Exception {
        if (args.length != 3) {
            throw new Exception("Please provide month, year and start day as arguments.");
        }
        try {
            int month = Integer.parseInt(args[0]);
            int year = Integer.parseInt(args[1]);
            int weekStartDay = Integer.parseInt(args[2]);
            if (month < 1 || month > 12 || weekStartDay < 1 || weekStartDay > 7) {
                throw new Exception("Month must be between 1 and 12, and start day must be between 1 and 7");
            }
            return new MonthYear(month, year, weekStartDay);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid number format for month or year, or start day");
        }
    }

    private static void printTitle(MonthYear monthYear) {
        String monthName = Month.of(monthYear.month()).name();
        System.out.printf("%9d, %s\n", monthYear.year(), monthName);
    }

    private static void printWeekDays(MonthYear monthYear) {
        for (int dayOfWeek = 0; dayOfWeek < 7; dayOfWeek++) {
            int currentDay = (monthYear.weekStartDay() + dayOfWeek - 1) % 7 + 1;
            DayOfWeek day = DayOfWeek.of(currentDay);
            System.out.printf("%3s", day.name().substring(0, 2));
        }
        System.out.println();
    }

    private static void printDates(MonthYear monthYear) {
        int firstDayOfWeek = getFirstDayOfWeek(monthYear);
        int lastDayOfMonth = getLastDayOfMonth(monthYear);
        int offset = getOffSet(firstDayOfWeek, monthYear);

        for (int i = 0; i < offset; i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= lastDayOfMonth; day++) {
            System.out.printf("%3d", day);
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

    private static int getOffSet(int firstWeekDay, MonthYear monthYear){
        return (firstWeekDay - monthYear.weekStartDay()+7) % 7;
    }

    private static int getLastDayOfMonth(MonthYear monthYear) {
        LocalDate lastDay = LocalDate.of(monthYear.year(), monthYear.month(), 1).withDayOfMonth(1).plusMonths(1).minusDays(1);
        return lastDay.getDayOfMonth();
    }
}