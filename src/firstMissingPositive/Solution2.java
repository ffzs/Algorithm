package firstMissingPositive;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/27
 */
public class Solution2 {
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for (int num : nums) {
            if (num > res) return res;
            else if (num == res) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1};
        System.out.println(firstMissingPositive(num));
    }
}
