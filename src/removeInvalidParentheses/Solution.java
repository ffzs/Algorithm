package removeInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/10/27 上午7:36
 */
public class Solution {
    Set<String> set = new HashSet<>();
    char[] cs;
    int len, max;
    public List<String> removeInvalidParentheses(String s) {
        cs = s.toCharArray();
        int l = 0, r = 0, c1 = 0, c2 = 0;
        for (char c : cs) {
            if (c == '(') {l ++; c1 ++;}
            else if (c == ')') {
                if (l != 0) l--;
                else r ++;
                c2++;
            }
        }
        len = cs.length - l - r;
        max = Math.min(c1, c2);
        dfs("", 0, l, r, 0);
        return new ArrayList<>(set);
    }

    private void dfs(String sb, int idx, int l, int r, int s) {
        if (l < 0 || r < 0 || s < 0 || s > max) return;
        if (l == 0 && r == 0) {
            if (sb.length() == len) set.add(sb);
        }
        if (idx >= cs.length) return;
        char c = cs[idx];

        if (c == '(') {
            dfs(sb + c, idx+1, l, r, s+1);
            dfs(sb, idx + 1, l-1, r, s);
        }
        else if (c == ')') {
            dfs(sb + c, idx+1, l, r, s-1);
            dfs(sb, idx+1, l, r-1, s);
        }
        else {
            dfs(sb + c, idx + 1, l, r, s);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeInvalidParentheses("()())()"));
    }
}
