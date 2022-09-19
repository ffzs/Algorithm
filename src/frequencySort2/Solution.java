package frequencySort2;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/9/19 上午8:37
 */

public class Solution {

    public int[] frequencySort(int[] nums) {
        int[] cnt = new int[201];
        int n = 0;
        for (int num : nums) {
            if (cnt[ num+100 ] == 0) n += 1;
            cnt[num + 100] += 1;
        }

        int[][] tmp = new int[n][2];
        for (int i = 0, j = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                tmp[j][0] = i - 100;
                tmp[j][1] = cnt[i];
                j += 1;
            }
        }
        Arrays.sort(tmp, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        for (int i = 0, j = 0; i < tmp.length; i++) {
            int num = tmp[i][0], freq = tmp[i][1];
            for (int k = 0; k < freq; k++) {
                nums[j++] = num;
            }
        }
        return nums;
    }

}
