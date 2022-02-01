package longestNiceSubstring;

/**
 * @author: ffzs
 * @Date: 2022/2/1 下午1:06
 */
public class Solution {

    public String longestNiceSubstring(String s) {
        char[] cs = s.toCharArray();
        int max = 0;
        int res = 0;
        for (int i = 0; i < cs.length - max; i++) {
            int lower = 0, upper = 0;
            for (int j = i; j < cs.length; j++) {
                if (cs[j] >= 'A' && cs[j] <= 'Z') upper |= 1 << (cs[j] - 'A');
                else lower |= 1 << (cs[j] - 'a');
                if (upper == lower && j - i + 1> max) {
                    max = j - i + 1;
                    res = i;
                }
            }
        }

        return s.substring(res, res + max);
    }

}
