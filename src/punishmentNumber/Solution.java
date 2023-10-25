package punishmentNumber;

/**
 * @author: ffzs
 * @Date: 2023/10/25 上午8:40
 */
public class Solution {

    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            char[] cs = String.valueOf(i*i).toCharArray();
            if (dfs(cs, 0, 0, i)) res += i*i;
        }
        return res;
    }

    private boolean dfs (char[] cs, int p, int total, int target) {
        if (p == cs.length) return total == target;

        int sum = 0;
        for (int i = p; i < cs.length; i++) {
            sum = sum * 10 + cs[i] - '0';
            if (sum + total > target) break;
            if (dfs (cs, i + 1, total + sum, target)) return true;
        }
        return false;
    }

}
