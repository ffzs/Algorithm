package findMaxLength;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/6/3 上午7:42
 */
public class Solution2 {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>() {{
            put(0, -1);
        }};
        int counter = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) counter++;
            else counter--;

            if (map.containsKey(counter)) res = Math.max(res, i - map.get(counter));
            else map.put(counter, i);
        }

        return res;
    }

}
