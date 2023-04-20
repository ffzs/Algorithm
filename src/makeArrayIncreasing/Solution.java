package makeArrayIncreasing;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/4/20 上午8:45
 */
public class Solution {
    int[][] dp;
    int n1,  n2;
    int[] arr1, arr2;
    final static int INF = Integer.MAX_VALUE >> 1;
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        n1 = arr1.length;
        n2 = arr2.length;
        dp = new int[n1+1][n2+1];
        Arrays.sort(arr2);
        this.arr1 = arr1;
        this.arr2 = arr2;
        int res = dfs(0,0,Integer.MIN_VALUE);
        return res == INF?-1:res;
    }


    private int dfs (int i, int j, int pre) {
        if (i >= n1) return 0;
        j = biSearch(arr2, j, pre);
        if (dp[i][j] != 0) return dp[i][j];
        int r1 = INF, r2 = INF;

        if (j < n2 && (arr2[j] < arr1[i] || arr1[i] <= pre)) r1 = 1 + dfs(i + 1, j + 1, arr2[j]);

        if (arr1[i] > pre) r2 = dfs (i + 1, j, arr1[i]);

        return dp[i][j] = Math.min(r1, r2);
    }



    private int biSearch (int[] arr2, int l, int t) {
        int r = arr2.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr2[mid] > t) r = mid;
            else l = mid + 1;
        }
        return l;
    }

}
