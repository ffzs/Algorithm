package pathInZigZagTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/7/29 上午7:00
 */
public class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        int r = 1, start = 1;
        while (start * 2 <= label) {
            r ++;
            start *= 2;
        }

        if (r % 2 == 0) label = reverse(label, r);
        List<Integer> res = new ArrayList<>();

        while (r > 0) {
            if (r % 2 == 0) res.add(0, reverse(label, r));
            else res.add(0, label);
            r --;
            label >>= 1;
        }
        return res;
    }

    private int reverse(int label, int r) {
        return (1 << r -1) + (1 << r) - 1 - label;
    }

}
