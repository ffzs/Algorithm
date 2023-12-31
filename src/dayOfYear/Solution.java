package dayOfYear;

/**
 * @author: ffzs
 * @Date: 2023/12/31
 */
public class Solution {
    static int[] dayInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        int[] day = formatDateString(date);
        int res = 0;
        for (int i = 0; i < day[1] - 1; i++) {
            res += dayInMonth[i];
        }

        res += day[2];

        if (isRunYear(day) && day[1] > 2) return res + 1;
        return res;
    }

    private static boolean isRunYear(int[] day) {
        return (day[0] % 4 == 0 && day[0] % 100 != 0) || (day[0] % 400 == 0);
    }

    private static int[] formatDateString(String date) {
        int[] day = new int[3];
        int idx = 0, tmp = 0;
        for (char c : date.toCharArray()) {
            if (c == '-') {
                day[idx++] = tmp;
                tmp = 0;
                continue;
            }

            tmp *= 10;
            tmp += c - '0';
        }
        day[2] = tmp;
        return day;
    }

}
