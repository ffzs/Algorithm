package judgePoint24;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2020/8/22 上午10:40
 */

public class Solution {
    public boolean judgePoint24(int[] nums) {
        int product = 1;
        boolean noOne = true;
        double[] numsDouble = new double[4];
        for (int i=0; i< 4; ++i) {
            product *= nums[i];
            if (nums[i]==1) noOne = false;
            numsDouble[i] = nums[i];
        }
        if (product<24 && noOne) return false;
        if (product == 24) return true;
        return dfs(numsDouble, 3);
    }

    private boolean dfs (double[] nums, int n) {
        if (n==0) return Math.abs(nums[0] - 24) < 1e-6;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                double[] subNum = new double[n];
                int idx = 0;
                for (int k = 0; k < nums.length; k++) {
                    if (k != i && k != j) {
                        subNum[idx] = nums[k];
                        idx ++;
                    }
                }
                boolean isValid;
                subNum[idx] = nums[i] + nums[j];
                isValid = dfs(subNum,n-1);
                if (!isValid) {
                    subNum[idx] = nums[i] - nums[j];
                    isValid = dfs(subNum,n-1);
                }
                if (!isValid) {
                    subNum[idx] = nums[j] - nums[i];
                    isValid = dfs(subNum,n-1);
                }
                if (!isValid) {
                    subNum[idx] = nums[j] * nums[i];
                    isValid = dfs(subNum,n-1);
                }
                if (!isValid && nums[i] !=0) {
                    subNum[idx] = nums[j] / nums[i];
                    isValid = dfs(subNum,n-1);
                }
                if (!isValid && nums[j] !=0) {
                    subNum[idx] = nums[i] / nums[j];
                    isValid = dfs(subNum,n-1);
                }
                if (isValid) return true;
            }
        }
        return false;
    }
}
