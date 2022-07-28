package fractionAddition;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/7/27 下午12:21
 */
public class Solution {

    static final int T = 3628800;
    public String fractionAddition(String expression) {
        if (expression.charAt(0) != '-') expression = "+" + expression;
        char[] cs = expression.toCharArray();
        int[] res = {0, T};
        int label = 1;
        int n = cs.length;

        for (int i = 0; i < n; i++) {
            if (cs[i] == '-' || cs[i] == '+') {
                if (cs[i] == '-') label = -1;
                else label = 1;
                i+=1;
                int a = 0, b = 0;
                while (cs[i] != '/') {
                    a = a * 10 + (cs[i] - '0');
                    i += 1;
                }
                i += 1;
                while (i < n && cs[i] != '-' && cs[i] != '+') {
                    b = b * 10 + (cs[i] - '0');
                    i += 1;
                }
                res[0] = res[0] + (T/b*a) * label;
                i-=1;
            }
        }


        if (res[0] % res[1] == 0) {
            res[0] /= res[1];
            res[1] /= res[1];
        }

        if (res[0] != 0 && res[1] % res[0] == 0) {
            res[1] /= Math.abs(res[0]);
            res[0] /= Math.abs(res[0]);
        }

        for (int i = 2; res[0] != 0 && i <= 10; i++) {
            while (res[0] % i == 0 && res[1] % i == 0) {
                res[0] /= i;
                res[1] /= i;
            }
        }

        return new StringBuilder().append(res[0]).append("/").append(res[1]).toString();
    }
}
