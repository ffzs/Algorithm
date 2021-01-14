package prefixesDivBy5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/1/14 下午8:24
 */
public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        long cur = 0;
        List<Boolean> res = new ArrayList<>(A.length);

        for (int value : A) {
            cur = ((cur << 1) + value) % 5;
            res.add(cur == 0);
        }
        return res;
    }
}
