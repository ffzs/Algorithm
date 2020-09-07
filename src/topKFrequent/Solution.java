package topKFrequent;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: ffzs
 * @Date: 2020/9/7 上午7:08
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.compute(num, (key, value)-> value = value == null? 1: value +1);
        }
        List<Integer> values = new ArrayList<>(numMap.values());
        values.sort(Comparator.reverseOrder());
        int[] res = new int[k];
        int aim = values.get(k-1);
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() >= aim) {
                res[i] = entry.getKey();
                i++;
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(solution.topKFrequent(nums, 2)));
    }
}
