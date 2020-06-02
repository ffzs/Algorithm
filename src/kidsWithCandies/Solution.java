package kidsWithCandies;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ffzs
 * @describe 1431. 拥有最多糖果的孩子
 * @date 2020/6/1
 */
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        List<Boolean> res = new ArrayList<>(candies.length);
        for (int candy: candies){
            max = Math.max(max, candy);
        }

        for (int candy : candies) {
            if (candy + extraCandies >= max) res.add(true);
            else res.add(false);
        }

        return res;
    }
}
