package minSubArrayLen;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/28
 */
public class Solution {
    public static int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        if (len == 0) return 0;
        int sum = nums[left];
        int res = len + 1;
        while (true) {
            if (sum >= s) {
                if (left == right) return 1;
                res = Math.min(res, right-left+1);
                sum -= nums[left ++];
            }
            else{
                right ++;
                if (right == len) break;
                sum += nums[right];
            }
        }
        return res==len+1 ? 0:res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
