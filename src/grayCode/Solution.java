package grayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/1/8 上午8:24
 */
public class Solution {

    public List<Integer> grayCode(int n) {
        int num = (int)Math.pow(2, n);
        int[] tmp = new int[num];

        tmp[0] = 0;
        tmp[1] = 1;
        int idx = 2;
        for (int i = 2; i < num; i <<= 1) {
            int next = idx + i;
            int cur = idx - 1;
            while (idx < next) tmp[idx++] += tmp[cur--] + i;
        }
        List<Integer> res = new ArrayList<>(num);
        for (int i : tmp) {
            res.add(i);
        }
        return res;
    }


}
