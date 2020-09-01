package PredictTheWinner;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/9/1 上午7:10
 */
public class Solution {
    int[][] step;
    int[] nums;
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        step = new int[n][n];
        this.nums = nums;
        for (int[] ints : step) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }

        return dfs(0, n-1) >= 0;
    }

    private int dfs (int left, int right) {
        if (left > right) return 0;

        if (step[left][right] != Integer.MIN_VALUE) return step[left][right];

        int leftScore = nums[left] - dfs(left+1, right);
        int rightScore = nums[right] - dfs(left, right-1);
        int score = Math.max(leftScore, rightScore);
        step[left][right] = score;
        return score;
    }
}
