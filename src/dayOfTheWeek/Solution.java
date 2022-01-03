package dayOfTheWeek;

/**
 * @author: ffzs
 * @Date: 2022/1/3 上午8:38 sunday
 */
public class Solution {
    static String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    static int[] dayInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] runYearCnt = new int[2100 + 1];
    static int startWeek;
    static {
        for (int i = 1971; i < runYearCnt.length; i++) {
            runYearCnt[i] = runYearCnt[i-1];
            if (isRunYear(i)) runYearCnt[i]++;
        }
        startWeek = (7 - ((2022 - 1971) * 365 + runYearCnt[2021] + 3 - 1)%7) % 7;
    }
    public String dayOfTheWeek(int day, int month, int year) {
        System.out.println(startWeek);
        int days = theDay(day, month, year);
        return week[(days-1 + startWeek) % 7];
    }

    private static int theDay(int day, int month, int year) {
        int days = (year - 1971) * 365 + runYearCnt[year - 1];
        for (int i = 0; i < month-1; i++) {
            days += dayInMonth[i];
        }
        days += day;
        if (isRunYear(year) && month > 2) days ++;
        return days;
    }

    private static boolean isRunYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
