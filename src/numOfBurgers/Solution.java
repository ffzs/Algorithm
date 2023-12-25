package numOfBurgers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/12/25 上午10:14
 */
public class Solution {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices % 2 != 0) return res;
        if (tomatoSlices > cheeseSlices * 4 || tomatoSlices < cheeseSlices * 2) return res;
        res.add((tomatoSlices - cheeseSlices * 2)/2);
        res.add(cheeseSlices - res.get(0));
        return res;

    }

}
