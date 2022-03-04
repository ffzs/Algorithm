package subArrayRanges;

/**
 * @author: ffzs
 * @Date: 2022/3/4 上午7:50
 *
 */
public class Solution {

    public long subArrayRanges(int[] nums) {
        long res = 0;
        int n = nums.length;
        int l, r;
        for (int i = 0; i < n; i++) {
            l = r = i;
            while (l - 1 >= 0 && nums[l-1] < nums[i]) l--;
            while (r + 1 < n && nums[r+1] <= nums[i]) r++;
            res += (r-i+1) * (i-l+1) * (long)nums[i];

            l = r = i;
            while (l - 1 >= 0 && nums[l-1] > nums[i]) l--;
            while (r + 1 < n && nums[r+1] >= nums[i]) r++;
            res -= (r-i+1) * (i-l+1) * (long)nums[i];
        }
        return res;
    }

}
