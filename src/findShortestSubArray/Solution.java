package findShortestSubArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/2/20 上午8:10
 */
public class Solution {

    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }
        int res = nums.length;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == max) {
                res = Math.min(res, getSubLen(nums, item.getKey()));
            }
        }
        return res;
     }

    private int getSubLen(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        while (nums[left] != k) left++;
        while (nums[right] != k) right--;
        return right-left+1;
    }
}
