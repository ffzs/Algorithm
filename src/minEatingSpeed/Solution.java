package minEatingSpeed;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/6/7 上午8:57
 */
public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        for (int pile : piles) {
            r =  Math.max(r, pile);
        }
        int l = 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (spendTime(piles, mid, h)) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private boolean spendTime (int[] piles, int speed, int h) {
        int ret = 0;
        for (int pile : piles) {
            ret += (pile + speed - 1) / speed;
            if (ret > h) return true;
        }
        return false;
    }

}
