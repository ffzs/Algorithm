package translateNum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/9
 */
public class Solution {
    public static int translateNum(int num) {
        int count = 0;
        // int 最长 10
        int[] tmp = new int[10];
        while (num > 9) {
            tmp[count] = num % 10;
            count ++;
            num /= 10;
        }
        int[] nums = new int[count+1];
        nums[0] = num;
        for (int i = 1; i <= count; i++) {
            nums[i] = tmp[count-i];
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i+1]= (nums[i-1]!=0 && (nums[i-1]*10+nums[i])<=25)?dp[i-1] + dp[i]:dp[i];
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(506));
    }
}
