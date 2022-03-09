package bestRotation;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/3/9 上午7:54
 */
public class Solution {

    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            int low = (i + 1 + n) % n;
            int high = (i - (nums[i] - 1) + n) % n;
            ++scores[low];
            --scores[high];
            if (low >= high) scores[0]++;
        }

        int max = 0, res = 0, c = 0;
        for (int i = 0; i < n; i++) {
            c += scores[i];
            if (c > max) {
                max = c;
                res = i;
            }
        }
        return res;
    }

}
