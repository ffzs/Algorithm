package splitArray;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author: ffzs
 * @Date: 2020/7/25 上午9:46
 */
public class Solution2 {
    public static int splitArray(int[] nums, int m) {
        int r = 0, l = 0;
        for (int num : nums) {
            r += num;
            l = Math.max(l, num);
        }
        l = Math.max(l, r/m);
        while (l < r) {
            int mid = l+r >>> 1;
            if (isMatch(nums, mid, m)) r = mid;
            else l = mid + 1;
        }

        return l;
    }

    private static boolean isMatch(int[] nums, int mid, int m) {
        int sum = 0, count = 1;
        for (int num : nums) {
            if (sum + num > mid) {
                sum = num; count++;
            }
            else
                sum += num;
        }
        return count <= m;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        System.out.println(splitArray(nums, 2));
    }
}