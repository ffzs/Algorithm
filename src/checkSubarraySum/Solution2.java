package checkSubarraySum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/6/2 上午8:01
 */
public class Solution2 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        int remainder = 0;
        Map<Integer, Integer> map = new HashMap<>(){{
            put(0,-1);
        }};

        for (int i = 0; i < n; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) return true;
            }
            else map.put(remainder, i);
        }

        return false;
    }

}
