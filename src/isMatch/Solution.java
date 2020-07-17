package isMatch;

/**
 * @author ffzs
 * @describe
 *
 * .* 无限跳过
 * . 跳过一个字符
 * * 跟前面字符相同的字符全部跳过
 **
 * @date 2020/6/20
 */
public class Solution {
    private int si = 0, pi = 0;
    private char[] ss, sp;
    public boolean isMatch(String s, String p) {
        if (s.length() == 0) {
            return p.length() == 0;
        }
        ss = s.toCharArray();
        sp = p.toCharArray();
        while (si < s.length() && pi < p.length()) {
            if (ss[si] == sp[pi]) {
                si ++;
                pi ++;
            }
            // 处理 . 和 .* 情况
            else if (sp[pi] == '.') {
                if (pi != sp.length-1 && sp[pi+1] == '*') {
                    if (pi + 1 == sp.length-1) return true;
                    else{
                        return isMatch(s, p, si, pi);
                    }
                }else{
                    si ++;
                    pi ++;
                }
            }else if (sp[pi] == '*'){

            }
            // 处理 下一位为 * 的情况， 这里要注意有可能出现 ppppp ， p*p的情况，因此p也是要跳过最后一个p的
            else if (pi != sp.length-1 && sp[pi+1] == '*') {
                char tmp = sp[pi];
                while (ss[si] == tmp) si++;
                pi += 2;
                while (sp[pi] == tmp ) pi++;
            }
            else {
                return false;
            }
        }
        return si == ss.length - 1 && pi == sp.length - 1;
    }

    public boolean isMatch(String s, String p, int si, int pi) {
        s = s.substring(si);
        p = p.substring(pi);
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        System.out.println(s.substring(1, s.length()-1));
    }
}
