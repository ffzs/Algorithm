package atMostNGivenDigitSet;

/**
 * @author: ffzs
 * @Date: 2022/10/18 下午7:07
 */
public class Solution {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        char[] cs = String.valueOf(n).toCharArray(), dgs = new char[digits.length];
        int len = cs.length, dl = digits.length;
        for (int i = 0; i < dl; i++) {
            dgs[i] = digits[i].charAt(0);
        }
        int res = 0;
        int[] tmp = new int[len];
        tmp[0] = 1;
        for (int i = 1; i < len; i++) {
            tmp[i] = tmp[i-1] * dl;
            res += tmp[i];
        }
        for (int i = 0; i < len; i++) {
            boolean needNext = false;
            for (char c : dgs) {
                if (c < cs[i]) res += tmp[len - i - 1];
                else if (c == cs[i]) {
                    needNext = true;
                    break;
                }
            }
            if (!needNext) return res;
        }
        return res + 1;
    }

}
