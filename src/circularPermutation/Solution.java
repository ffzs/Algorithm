package circularPermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/2/23 上午9:58
 */
public class Solution {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>(1<<n);
        for (int i = 0; i < (1<<n); i++) {
            res.add((i ^ i >> 1) ^ start);
        }
        return res;
    }

}
