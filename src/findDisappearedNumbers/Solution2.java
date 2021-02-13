package findDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/2/13 上午8:52
 */
public class Solution2 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        boolean[] tmp = new boolean[n + 1];

        for (int num : nums) {
            tmp[num] = true;
        }

        for (int i = 1; i < tmp.length; i++) {
            if (!tmp[i]) res.add(i);
        }

        return res;
    }
}
