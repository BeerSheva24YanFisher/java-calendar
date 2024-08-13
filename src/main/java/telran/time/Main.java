package telran.time;

import java.time.LocalDate;

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
        return null;
    }

    private static void printTitle(MonthYear monthYear) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void printWeekDays() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void printDates(MonthYear monthYear) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private int getFirstDayOfWeek(MonthYear monthYear){
        LocalDate firstDay = LocalDate.of(monthYear.year(), monthYear.month(), 1);
        return firstDay.getDayOfWeek().getValue();
    }

    private int getOffSet(int firstWeekDay){
        return firstWeekDay % 7;
    }

    private static int getLastDayOfMonth(MonthYear monthYear) {
        LocalDate lastDay = LocalDate.of(monthYear.year(), monthYear.month(), 1)
                                      .withDayOfMonth(1)
                                      .plusMonths(1)
                                      .minusDays(1);
        return lastDay.getDayOfMonth();
    }
}