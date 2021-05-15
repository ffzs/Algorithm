package romanToInt;

/**
 * @author: ffzs
 * @Date: 2021/5/15 上午8:36
 */
public class Solution2 {

    public int romanToInt(String s) {
        char[] cs = s.toCharArray();

        int i = 0, res = 0;
        while (i < cs.length) {
            switch (cs[i]) {
                case 'C':
                    if (i + 1 == cs.length || (i + 1 < cs.length && cs[i + 1] != 'M' && cs[i + 1] != 'D')) res += 100;
                    else {
                        if (cs[i + 1] == 'M') res += 900;
                        else res += 400;
                        i++;
                    }
                    break;
                case 'X':
                    if (i + 1 == cs.length || (i + 1 < cs.length && cs[i + 1] != 'C' && cs[i + 1] != 'L')) res += 10;
                    else {
                        if (cs[i + 1] == 'C') res += 90;
                        else res += 40;
                        i++;
                    }
                    break;
                case 'I':
                    if (i + 1 == cs.length || (i + 1 < cs.length && cs[i + 1] != 'X' && cs[i + 1] != 'V')) res += 1;
                    else {
                        if (cs[i + 1] == 'X') res += 9;
                        else res += 4;
                        i++;
                    }
                    break;
                case 'M':
                    res += 1000;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'V':
                    res += 5;
                    break;
            }
            i++;
        }

        return res;
    }

}
