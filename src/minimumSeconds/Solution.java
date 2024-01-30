package minimumSeconds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2024/1/30 下午10:03
 */
public class Solution {

    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> pre = new HashMap<>();
        Map<Integer, Integer> gap = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            int k = nums.get(i);
            if (!start.containsKey(k)) {
                start.put(k, i);
            }
            if (!gap.containsKey(k)) {
                gap.put(k, i - pre.getOrDefault(k, i));
            } else {
                int g = i - pre.get(k);
                if (g > gap.get(k)) {
                    gap.put(k, g);
                }
            }
            pre.put(k, i);
        }

        if (start.size() == 1) return 0;
        int res = Integer.MAX_VALUE;
        for (int k : start.keySet()) {
            int v = !start.get(k).equals(pre.get(k)) ? start.get(k) + nums.size() - pre.get(k) : Integer.MAX_VALUE;
            res = Math.min(res, Math.max(gap.get(k), v));
        }
        System.out.println(res);
        if (res == Integer.MAX_VALUE) return nums.size() / 2;
        return res / 2;
    }

}
