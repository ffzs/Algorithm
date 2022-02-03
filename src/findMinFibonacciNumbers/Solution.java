package findMinFibonacciNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/2/3 上午8:28
 */
public class Solution {

    public int findMinFibonacciNumbers(int k) {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        int f1 = 1, f2 = 1;
        while (f1 + f2 <= k) {
            int f3 = f1 + f2;
            lst.add(f3);
            f1 = f2;
            f2 = f3;
        }
        int res = 0;
        for (int i = lst.size() - 1; i >= 0 && k > 0; i--) {
            int cur = lst.get(i);
            if (k >= cur) {
                k -= cur;
                res ++;
            }
        }
        return res;
    }

}
