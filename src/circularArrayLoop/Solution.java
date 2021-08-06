package circularArrayLoop;

/**
 * @author: ffzs
 * @Date: 2021/8/7 上午6:48
 */
public class Solution {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int s = i, f = next(nums, i);
            while (nums[s] * nums[f] > 0 && nums[s] * nums[next(nums, f)] > 0) {
                if (s == f) {
                    if (s != next(nums, s)) return true;
                    else break;
                }
                s = next(nums, s);
                f = next(nums, next(nums, f));
            }
            int add = i;
            while (nums[add] * nums[next(nums, add)] > 0) {
                int t = add;
                add = next(nums, add);
                nums[t] = 0;
            }
        }
        return false;
    }

    private int next(int[] nums, int i) {
        int n = nums.length;
        // 有可能为负
        return ((i + nums[i]) % n + n) % n;
    }

}
