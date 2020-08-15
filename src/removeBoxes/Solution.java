package removeBoxes;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/8/15 上午10:33
 */
public class Solution {

    int[][][] dp;
    int[] boxes;
    public int removeBoxes(int[] boxes) {
        int[] valueCount = new int[101];
        for (int box : boxes) valueCount[box]++;
        int[] tmp = new int[boxes.length];
        int idx = 0;
        for (int box : boxes) {
            if (valueCount[box] > 1) {
                tmp[idx] = box;
                idx++;
            }
        }

        this.boxes = Arrays.copyOf(tmp, idx);
        dp = new int[idx][idx][idx];
        return dfs(0, this.boxes.length-1, 0) + tmp.length-idx;
    }

    private int dfs (int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0) return dp[l][r][k];
        while (r > l && boxes[r] == boxes[r-1]) {
            r --;  k ++;
        }
        dp[l][r][k] = dfs(l, r-1, 0) + (k + 1) * (k + 1);

        for (int i = l; i< r; ++i){
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], dfs(l, i, k+1)+dfs(i+1, r-1, 0));
            }
        }
        return dp[l][r][k];
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] boxes = {1,3,2,2,2,3,4,3,1};
        System.out.println(solution.removeBoxes(boxes));
    }
}