package maxCoins;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/7/19 上午7:59
 */

public class Solution {
    static int[] ns;
    static int[][] step;
    public static int maxCoins(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        ns = new int[len+2];
        System.arraycopy(nums,0, ns, 1, len);
        ns[0] = ns[len+1] = 1;
        step = new int[len+2][len+2];

        return maxCoins(0, len+1);
    }

    private static int maxCoins (int l, int r) {
        if (l + 1 == r) return 0;   // l, l+1 之间没有气球，返回0
        if (step[l][r] != 0) return step[l][r];   // 访问过的直接返回

        int max = 0;
        for (int mid = l+1; mid < r; ++mid) {
            max = Math.max(max, maxCoins(l, mid) + maxCoins(mid, r) + ns[l]*ns[r]*ns[mid]);
        }
        step[l][r] = max;
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(maxCoins(nums));
    }
}
