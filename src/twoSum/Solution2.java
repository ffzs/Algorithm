package twoSum;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/7/20 上午8:31
 */
public class Solution2 {
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) r--;
            else if (numbers[l] + numbers[r] < target) l++;
            else if (numbers[l] + numbers[r] == target)
                return new int[]{l+1, r+1};
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
