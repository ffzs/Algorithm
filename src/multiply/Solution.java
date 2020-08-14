package multiply;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/8/13 上午7:46
 */
public class Solution {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num2.length();
        int n = num1.length();
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int[] tmp = new int[m+n];

        for (int i = 0; i < m; ++i) {
            int v2 = char2[m-1-i] - '0';
            int carry1 = 0;
            int carry2 = 0;
            for (int j = 0; j < n; ++j) {
                int v1 = char1[n-1-j] - '0';
                int product = v1 * v2 + carry2;
                int remainder = product % 10;
                carry2 = product / 10;
                int sum = remainder + tmp[i+j] + carry1;
                carry1 = sum/10;
                tmp[i+j] = sum % 10;
            }
            if (carry2 != 0 || carry1 != 0) {
                int sum = tmp[i+n] + carry2 + carry1;
                tmp[i+n] = sum % 10;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--) {
            if (i == tmp.length - 1 && tmp[i] == 0) continue;
            res.append(tmp[i]);
        }

        return res.toString();
    }
}

class Test {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String num1 = "9";
        String num2 = "99";
        System.out.println(solution.multiply(num1, num2));
    }
}
