package minLength;

/**
 * @author: ffzs
 * @Date: 2024/1/10 下午7:39
 */
public class Solution {

    public int minLength(String s) {
        char[] cs = s.toCharArray();
        int[] stack = new int[cs.length];
        int idx = 0, res = 0;
        for (char c : cs) {
            if (idx > 0 && ((c == 'B' && stack[idx-1] == 'A') || (c == 'D' && stack[idx-1] == 'C'))) {
                res += 2;
                idx--;
                continue;
            }
            stack[idx++] = c;
        }
        return cs.length - res;
    }

}
