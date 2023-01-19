package strongPasswordCheckerII;

/**
 * @author: ffzs
 * @Date: 2023/1/19 上午9:12
 */
public class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        int lower = 0, upper = 0, digit = 0;
        char[] cs = password.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i != 0 && cs[i] == cs[i-1]) return false;
            if (cs[i] >= '0' && cs[i] <='9') digit += 1;
            else if (cs[i] >= 'a' && cs[i] <= 'z') lower += 1;
            else if (cs[i] >= 'A' && cs[i] <= 'Z') upper += 1;
        }
        return lower != 0 && upper != 0 && digit != 0 && (digit + upper + lower) != cs.length;
    }
}
