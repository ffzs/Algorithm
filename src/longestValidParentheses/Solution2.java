package longestValidParentheses;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/4
 */
public class Solution2 {
    public static int longestValidParentheses(String s) {
        char[] seq = s.toCharArray();
        int left = 0, right = 0;
        int res = 0;
        for (char c : seq) {
            if (c == '(') left ++;
            else right ++;
            if (left == right) res = Math.max(res, left*2);
            else if (left < right) left = right = 0;
        }

        left = right = 0;
        for (int i = seq.length-1; i >= 0; --i) {
            if (seq[i] == '(') left ++;
            else right ++;
            if (left == right) res = Math.max(res, left*2);
            else if (right < left) left = right = 0;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "(())()(()((";
        System.out.println(longestValidParentheses(s));
    }
}
