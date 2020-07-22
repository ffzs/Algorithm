package minArray;

/**
 * @author: ffzs
 * @Date: 2020/7/22 上午7:53
 */
public class Solution {
    public static int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length ; i++) {
            if (numbers[i-1] > numbers[i]) return numbers[i];
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(minArray(nums));
    }
}
