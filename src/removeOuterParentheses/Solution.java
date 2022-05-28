package removeOuterParentheses;

/**
 * @author: ffzs
 * @Date: 2022/5/28 上午8:51
 */
public class Solution {

    public String removeOuterParentheses(String s) {
        char[] cs = s.toCharArray();

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : cs) {
            if (c == '(') {
                if (cnt != 0) sb.append('(');
                ++cnt;
            }
            if (c == ')') {
                --cnt;
                if (cnt != 0) sb.append(')');
            }
        }
        return sb.toString();
    }

}
