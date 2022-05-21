package repeatedNTimes;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2022/5/21 上午8:12
 */
public class Solution {

    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }

}
