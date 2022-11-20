package champagneTower;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/11/20 下午4:12
 */
public class Solution {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] glasses = new double[query_row + 1];
        glasses[0] = poured;
        double pre, cur;
        boolean flag;
        for (int i = 1; i <= query_row; i++) {
            pre = 0D;
            cur = 0D;
            flag = false;
            for (int j = 0; j < i; j++) {
                cur = Math.max(0, (glasses[j] - 1)/2);
                glasses[j] = pre + cur;
                if (glasses[j] > 0) flag = true;
                pre = cur;
            }

            if (!flag) return 0D;
            glasses[i] = glasses[0];
        }
        return Math.max(0D, Math.min(glasses[query_glass], 1));
    }

}
