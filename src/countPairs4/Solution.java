package countPairs4;

import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/11/24 下午10:09
 */
public class Solution {

    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n ; ++ i) {
            int a = nums.get(i);
            for (int j = i + 1; j < n; j++) {
                if (a + nums.get(j) < target) res ++;
            }
        }
        return res;
    }

}
