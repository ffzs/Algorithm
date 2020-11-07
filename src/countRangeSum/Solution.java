package countRangeSum;


import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/11/7 上午8:30
 */
public class Solution {
    int res = 0;
    int lower, upper;
    long[] sums;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        sums = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        sort(new long[sums.length], 0, nums.length);
        return res;
    }


    private void sort (long[] tmp, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) >>> 1;

        sort(tmp, left, mid);
        sort(tmp, mid + 1, right);
        merge(tmp, left, mid ,right);
    }

    private void merge(long[] tmp, int left, int mid, int right) {
        if (right + 1 - left >= 0) System.arraycopy(sums, left, tmp, left, right + 1 - left);

        int i = left, j = mid + 1;
        int low = mid + 1, up = mid + 1;

        for (int k = left; k <= right; k++) {
            // 找到[lower, upper] 的左index
            while (low <= right && tmp[low] - tmp[i] < lower) low ++;
            // 找到[lower, upper] 的右index
            while (up <= right && tmp[up] - tmp[i] <= upper) up ++;

            if (i > mid) {
                sums[k] = tmp[j++];
            } else if (j > right) {
                sums[k] = tmp[i++];
                res += up - low;
            } else if (tmp[i] > tmp[j]) {
                sums[k] = tmp[j++];
            } else {
                sums[k] = tmp[i++];
                res += up - low;
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {-2147483647,0,-2147483647,2147483647};
//        int[] nums = {-2,5,-1};
        int lower = -564, upper = 3864;
        Solution solution = new Solution();
        System.out.println(solution.countRangeSum(nums, lower, upper));
    }
}
