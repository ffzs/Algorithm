package makesquare;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/6/1 上午8:46
 */
public class Solution {
    int n, total = 0, edge;
    int[] sticks;
    boolean[] visited;
    public boolean makesquare(int[] matchsticks) {
        n = matchsticks.length;
        for (int m : matchsticks) total += m;
        if (total % 4 != 0) return false;
        edge = total / 4;
        sticks = matchsticks;
        Arrays.sort(sticks);
        if (sticks[n - 1] > edge) return false;
        visited = new boolean[n];
        return dfs(n-1, 0, 0);
    }

    private boolean dfs (int i, int val, int cnt) {
        if (cnt == 3) return true;
        if (val == edge) {
            return dfs(n-1, 0, cnt + 1);
        }

        for (int j = i; j >= 0; j--) {
            if (!visited[j]) {
                if (val + sticks[j] <= edge) {
                    visited[j] = true;
                    if (dfs(j-1, val + sticks[j], cnt)) return true;
                    visited[j] = false;
                }
                while (j - 1 >= 0 && sticks[j] == sticks[j - 1]) --j;
            }
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        int[] matchsticks = {6,6,6,6,4,2,2};
        Solution s = new Solution();
        System.out.println(s.makesquare(matchsticks));
    }
}
