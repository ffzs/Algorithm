package xorGame;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/5/22 下午1:33
 */
public class Solution2 {

    public boolean xorGame(int[] nums) {
        return nums.length % 2 == 0 || Arrays.stream(nums).boxed().reduce((a,b) -> a^b).get() == 0;
    }
}
