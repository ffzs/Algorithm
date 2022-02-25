package complexNumberMultiply;

import java.util.regex.Pattern;

/**
 * @author: ffzs
 * @Date: 2022/2/25 上午7:59
 */
public class Solution {

    public String complexNumberMultiply(String num1, String num2) {
        int[] p1 = helper(num1);
        int[] p2 = helper(num2);
        StringBuilder sb = new StringBuilder();
        sb.append(p1[0] * p2[0] - p1[1] * p2[1]).append('+').append(p1[0] * p2[1] + p1[1] * p2[0]).append('i');
        return sb.toString();
    }

    private int[] helper (String num) {
        int i = 0;
        while (num.charAt(i) != '+') i++;
        return new int[]{Integer.parseInt(num.substring(0,i)), Integer.parseInt(num.substring(i+1, num.length()-1))};
    }

}
