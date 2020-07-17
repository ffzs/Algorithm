package countSmaller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/11
 */
public class Solution {
    public static List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        if (len == 0) return res;
        int[] counter = new int[len];
        int min = nums[0];
        for (int num : nums) min = Math.min(min, num);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min + 1;
        }
        int max = nums[0];
        for (int num : nums) max = Math.max(max, num);
        int[] BIT = new int[max + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            int count = sum(nums[i]-1, BIT);
            counter[i] = count;
            update(nums[i], BIT);
        }
        for (int i : counter) res.add(i);
        return res;
    }

    private static int lowBit (int val) {
        return (val & -val);
    }

    private static int sum (int val, int[] BIT){
        int sum = 0;
        for (int i = val; i > 0; i -= lowBit(i)) {
            sum += BIT[i];
        }
        return sum;
    }

    private static void update (int val, int[] BIT){
        for (int i = val; i < BIT.length - 1; i += lowBit(i)) {
            BIT[i] += 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(countSmaller(nums));
    }
}
