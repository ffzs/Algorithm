package trailingZeroes;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2022/3/25 上午8:00
 */
public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }

}
