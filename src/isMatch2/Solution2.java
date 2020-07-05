package isMatch2;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/5
 */
public class Solution2 {
    public static boolean isMatch(String s, String p) {
        int si = 0, pi = 0, ss = -1, sp = -1;
        while (si < s.length()) {
            if (pi < p.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')) {
                si ++; pi++;
            }
            else if (pi < p.length() && p.charAt(pi) == '*') {
                ss = si; sp = pi++;
            }
            else if (ss != -1) {
                si = ++ss; pi = sp;
            }
            else return false;
        }
        while (pi < p.length() && p.charAt(pi) == '*') pi++;
        return pi == p.length();
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        System.out.println(isMatch(s, p));
    }
}
