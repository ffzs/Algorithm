package findLexSmallestString;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/3/19 上午9:43
 */
public class Solution {

    public String findLexSmallestString(String s, int a, int b) {
        boolean[] isValid = new boolean[10];
        int it = a;
        while (!isValid[it]) {
            isValid[it] = true;
            it += a;
            it %= 10;
        }

        int[] trans = new int[10];
        for (int i = 0; i < 10; i++) {
            trans[i] = transNum(i, isValid);
        }

        int n = s.length();
        String res = s;
        s = s + s;
        int g = gcd(b, n);

        for (int i = 0; i < n; i+=g) {
            // 这里还可以优化，首个为最小情况执行，否则continue
            char[] cs = s.substring(i, i + n).toCharArray();
            findIndex(cs, 1, trans[cs[1]-'0']);
            if ((b & 1) == 1) {
                findIndex(cs, 0, trans[cs[0]-'0']);
            }
            String ss = new String(cs);
            if (ss.compareTo(res) < 0) res = ss;
        }
        return res;
    }

    private int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private void findIndex (char[] cs, int start, int a) {
        int diff = cs[start] - '0' - a;
        for (int i = start; i < cs.length; i+=2) {
            cs[i] = (char)((cs[i] - '0' - diff + 10) % 10 + '0');
        }
    }


    private int transNum (int num, boolean[] isValid) {
        if (num == 0) return num;
        for (int i = 0; i <= 9; i++) {
            if (isValid[i]) {
                int it = (num + i) % 10;
                if (it < num) return it;
            }
        }
        return num;
    }

}
