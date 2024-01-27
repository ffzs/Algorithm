package maxNumberOfAlloys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: ffzs
 * @Date: 2024/1/27 下午7:48
 */
public class Solution {

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost){
        int res = 0;
        int l = 1;
        int r = budget/cost.get(0) + stock.get(0);

        while (l <= r) {
            int mid = (l + r) >>> 1;
            boolean flag = false;
            for (int i = 0; i < k; i++) {
                long total = 0;
                for (int j = 0; j < n; j++) {
                    total += Math.max((long) composition.get(i).get(j) * mid - stock.get(j), 0) * cost.get(j);
                }
                if (total <= budget) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

}
