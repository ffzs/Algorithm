package maxNumber;


/**
 * @author: ffzs
 * @Date: 2020/12/2 上午8:36
 */
public class Solution2 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[k];
        for (int i = 0; i <= k && i <= n1; i++) {
            if (k - i >= 0 && k - i <= n2) {
                int[] tmp = merge(sub(nums1, i), sub(nums2, k - i));
                if (compare(tmp, 0, res, 0)) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    private int[] sub(int[] nums, int k){
        int[] subNums = new int[k];
        int cur = 0, rem = nums.length - k;
        for (int num : nums) {
            while (cur > 0 && subNums[cur - 1] < num && rem > 0) {
                cur--;
                rem--;
            }
            if (cur < k) {
                subNums[cur++] = num;
            } else {
                rem--;
            }
        }
        return subNums;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int cur = 0, p1 = 0, p2 = 0;
        while (cur < nums1.length + nums2.length) {
            if (compare(nums1, p1, nums2, p2)) {
                res[cur++] = nums1[p1++];
            } else {
                res[cur++] = nums2[p2++];
            }
        }
        return res;
    }

    public boolean compare(int[] nums1, int i1, int[] nums2, int i2) {
        int x = nums1.length, y = nums2.length;
        while (i1 < x && i2 < y) {
            int difference = nums1[i1] - nums2[i2];
            if (difference != 0) return difference > 0;
            i1++;
            i2++;
        }
        return (x - i1) - (y - i2) > 0;
    }
}
