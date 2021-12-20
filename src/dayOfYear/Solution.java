package dayOfYear;

/**
 * @author: ffzs
 * @Date: 2021/12/21 上午7:45
 */
public class Solution {
    static int[] dayInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    public int dayOfYear(String date) {
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
        int res = 0;
        for (int i = 0; i < day[1]-1; i++) {
            res += dayInMonth[i];
        }

        res += day[2];

        if (((day[0] % 4 == 0 && day[0] % 100 != 0) || (day[0] % 400 == 0)) && day[1] > 2) res++;
        return res;
    }

}
