package TreeAncestor;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/6/12 上午6:46
 */
public class TreeAncestor {
    int[][] dp;
    public TreeAncestor(int n, int[] parent) {
        dp = new int[n][16];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][0] = parent[i];
        }

        for (int i = 1; i < 16; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                int ff = dp[j][i-1] == -1?-1: dp[dp[j][i-1]][i-1];
                dp[j][i] = ff;
                if (ff != -1) {
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < 16; i++) {
            if (((k >> i) & 1) != 0) {
                node = dp[node][i];
                if (node == -1) break;
            }
        }
        return node;
    }

}
