package RandomPickIndex;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: ffzs
 * @Date: 2022/4/25 上午8:31
 */
public class Solution {
    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int res = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ++cnt;
                if (random.nextInt(cnt) == 0) res = i;
            }
        }
        return res;
    }
}
