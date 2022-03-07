package convertToBase7;

/**
 * @author: ffzs
 * @Date: 2022/3/7 上午8:27
 *
 * 100 / 7 = 14 ... 2
 * 14 / 7 = 2 ... 0
 * 2 /7 = 0 ... 2
 */
public class Solution {

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean under = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        sb.reverse();
        if (under) sb.insert(0, '-');
        return sb.toString();
    }
}
