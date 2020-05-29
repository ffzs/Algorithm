package maxProduct;

/**
 * @author ffzs
 * @describe 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @date 2020/5/18
 */
public class maxProduct2 {
    public static int maxProduct(int[] nums) {
        int len = nums.length, left=1, right=1, max=nums[0];
        for (int i = 0; i < len; i++) {
            left = left*nums[i];
            right = right*nums[len-i-1];
            max = Math.max(max, Math.max(left, right));
            if (left==0) left = 1;
            if (right==0) right = 1;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,0};
        System.out.println(maxProduct(nums));
    }
}
