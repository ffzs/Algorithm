package scoreOfParentheses;

/**
 * @author: ffzs
 * @Date: 2022/10/9 下午12:33
 */
public class Solution {

    public int scoreOfParentheses(String s) {
        return helper(s, true);
    }

    private int helper (String s, boolean flag) {
        if (s.equals("()")) return 1;
        if (flag) {
            int res = 0, start = 0, cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') cnt += 1;
                else cnt -= 1;
                if (cnt == 0) {
                    res += helper(s.substring(start, i + 1), false);
                    start = i + 1;
                }
            }
            return res;
        }
        else return 2 * helper(s.substring(1, s.length()-1), true);
    }

}
