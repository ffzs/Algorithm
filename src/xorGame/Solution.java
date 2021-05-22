package xorGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: ffzs
 * @Date: 2021/5/22 上午9:50
 */
public class Solution {

    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) return true;

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res == 0;
    }
}
