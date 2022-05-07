package minMutation;

/**
 * @author: ffzs
 * @Date: 2022/5/7 上午8:47
 */
public class Solution {

    int res = Integer.MAX_VALUE;
    boolean[] used;
    public int minMutation(String start, String end, String[] bank) {
        used = new boolean[bank.length];
        dfs(start, end, 0, bank);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs (String s, String e, int c, String[] bank) {
        if (c >= res) return;
        if (s.equals(e)) {
            res = c;
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            if (used[i]) continue;
            if (onEdge(s, bank[i])) {
                used[i] = true;
                dfs (bank[i], e, c + 1, bank);
                used[i] = false;
            }
        }
    }

    private boolean onEdge (String s1, String s2) {
        int c = 0;
        for (int i = 0; i < 8; i++) {
            if (s1.charAt(i) != s2.charAt(i)) ++c;
            if (c > 1) return false;
        }
        return true;
    }
}
