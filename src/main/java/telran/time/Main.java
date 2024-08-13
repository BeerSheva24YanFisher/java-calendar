package telran.time;

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
        return 0;
    }

    private int getOffSet(int firstWeekDay){
        //shift on this offset for starting println
        return 0;
    }

    private int getLastDayOfMonth(MonthYear monthyear){
        return 0;
    }
}