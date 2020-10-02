package towSum2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2020/10/3 上午7:09
 */
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target-num)) {
                return new int[]{i, map.get(target-num)};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
