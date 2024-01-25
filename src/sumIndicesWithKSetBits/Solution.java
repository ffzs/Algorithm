package sumIndicesWithKSetBits;

import java.util.List;

/**
 * @author: ffzs
 * @Date: 2024/1/25 下午10:51
 */
public class Solution {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                res += nums.get(i);
            }
        }
        return res;
    }

}
