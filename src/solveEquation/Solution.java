package solveEquation;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/8/10 上午10:23
 */
public class Solution {

    public String solveEquation(String equation) {
        int i = equation.indexOf('=');
        int[] pre = parse(equation.substring(0, i)), suf = parse(equation.substring(i+1));
        if (pre[0] == suf[0]) {
            if (pre[1] != suf[1]) return "No solution";
            else return "Infinite solutions";
        }
        return "x=" + (suf[1] - pre[1]) / (pre[0]-suf[0]);
    }

    private int[] parse (String s) {
        s = s + "+";
        char[] cs = s.toCharArray();

        int[] ret = new int[2];
        int num = 0, label = 1, isX = 0;

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == 'x') {
                if (i == 0 || (cs[i-1] == '+' || cs[i-1] == '-')) isX = 2;
                else isX = 1;
            }
            else if (c == '+' || c == '-') {
                if (isX != 0) {
                    ret[0] += isX == 2 ? label: label * num;
                }
                else ret[1] += label * num;
                label = c == '+' ? 1 : -1;
                num = 0;
                isX = 0;
            }
            else {
                num *= 10;
                num += c - '0';
            }
        }
        System.out.println(Arrays.toString(ret));
        return ret;
    }
}
