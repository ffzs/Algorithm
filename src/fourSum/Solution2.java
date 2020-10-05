package fourSum;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/10/5 上午7:25
 */
public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        this.nums = nums;
        int n = nums.length;
        for (int i = 0; i < n-3; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            if ((nums[i] + nums[n-1] + nums[n-2] + nums[n-3]) < target) continue;
            if ((nums[i] + nums[i+1] + nums[i+2] + nums[i+3]) > target) break;
            for (int j = i + 1; j < n - 2; j++) {
                if ((j > i+1 && nums[j] == nums[j-1])||(nums[i] + nums[j]+ nums[n-1] + nums[n-2]) < target) continue;
                if ((nums[i] + nums[j] + nums[j+1] + nums[j+2])>target) break;
                twoSum(j+1,n-1, target, nums[i], nums[j]);
            }
        }
        return res;
    }

    private void twoSum (int i, int j, int target, int left, int right) {
        while (i < j) {
            int ret = left + right + nums[i] + nums[j] - target;
            if (ret>0) j--;
            else if (ret==0) {
                res.add(Arrays.asList(left,nums[i], nums[j], right));
                while (i < j && nums[i] == nums[++i]);
                while (i < j && nums[j] == nums[--j]);
            }
            else i++;
        }
    }
}
