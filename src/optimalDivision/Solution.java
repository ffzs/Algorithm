package optimalDivision;

/**
 * @author: ffzs
 * @Date: 2022/2/27 上午8:05
 */
public class Solution {

    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return String.valueOf(nums[0]);
        if (nums.length == 2) return new StringBuilder().append(nums[0]).append('/').append(nums[1]).toString();
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append('/').append('(');
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]).append('/');
        }
        sb.setCharAt(sb.length()-1, ')');
        return sb.toString();
    }

}
