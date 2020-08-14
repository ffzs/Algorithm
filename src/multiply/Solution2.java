package multiply;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/8/13 上午8:41
 */
public class Solution2 {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num2.length();
        int n = num1.length();
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int[] tmp = new int[m+n];

        for (int i = 0; i < m; ++i) {
            int v2 = char2[m-1-i] - '0';
            for (int j = 0; j < n; ++j) {
                int v1 = char1[n-1-j] - '0';
                tmp[i+j] += v1*v2;
            }
        }

        int carry = 0;
        for (int i = 0; i < tmp.length; ++i) {
            int sum = tmp[i] + carry;
            carry = sum / 10;
            tmp[i] = sum % 10;
        }


        StringBuilder res = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--) {
            if (i == tmp.length - 1 && tmp[i] == 0) continue;
            res.append(tmp[i]);
        }

        return res.toString();
    }
}
