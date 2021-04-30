package singleNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/4/30 下午12:32
 */
public class Solution2 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }

        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == 1) return item.getKey();
        }
        return nums[0];
    }

}

