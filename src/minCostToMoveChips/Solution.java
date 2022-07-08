package minCostToMoveChips;

/**
 * @author: ffzs
 * @Date: 2022/7/8 上午8:23
 */
public class Solution {

    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int i : position) {
            if ((i & 1) == 1) odd += 1;
            else even += 1;
        }
        return Math.min(odd, even);
    }

}
