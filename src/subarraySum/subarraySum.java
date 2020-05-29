package subarraySum;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class subarraySum {
    public static int subarraySum(int[] nums, int k){
        int len=nums.length, max=nums[0], min=nums[0], res=0;
        for (int i=1; i<len; ++i){
            nums[i] += nums[i-1];
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        int[] tmp = new int[max-min+1];
        for (int num : nums) {
            if (num == k) res++;
            if (num - k >= min && num - k <= max) {
                res += tmp[num - k - min];
            }
            tmp[num - min]++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,-1,1};
        int[] nums = {0,0,0,0,0,0,0,0,0,0};
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }
}
