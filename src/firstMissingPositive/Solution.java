package firstMissingPositive;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/27
 */
public class Solution {
    public static int firstMissingPositive(int[] nums) {
        boolean[] tmp = new boolean[nums.length+2];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                tmp[num] = true;
            }
        }
        for (int i = 1; i < tmp.length; i++) {
            if(!tmp[i]) return i;
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] num = {1};
        System.out.println(firstMissingPositive(num));
    }
}
