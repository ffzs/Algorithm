package longestConsecutive;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/6
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 1;
        for (int value : nums) {
            if (!set.contains(value - 1)) {
                int count = 1;
                int num = value;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }
}
