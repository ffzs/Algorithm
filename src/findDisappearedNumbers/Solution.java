package findDisappearedNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/2/13 上午8:34
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        Arrays.sort(nums);

        if (nums[0] != 1) {
            for (int i = 1; i < nums[0]; i++) {
                res.add(i);
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] + 1 != nums[i]) {
                for (int j = nums[i-1] + 1; j < nums[i]; j++) {
                    res.add(j);
                }
            }
        }
        if (nums[n-1] != n) {
            for (int i = nums[n - 1] + 1; i <= n; i++) {
                res.add(i);
            }
        }
        return res;
    }

}
