package findSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/2/18 下午1:43
 */

class CustomFunction {
    public int f(int x, int y) {
        return 0;
    }
}

public class Solution {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int y = 1000;
        for (int x = 1; x <= 1000; x++) {
            while (customfunction.f(x, y) > z) y-=1;
            if (y <= 0) break;
            if (customfunction.f(x, y) == z) res.add(List.of(x,y));
        }
        return res;
    }

}
