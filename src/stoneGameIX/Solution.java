package stoneGameIX;

/**
 * @author: ffzs
 * @Date: 2022/1/20 上午8:33
 */

public class Solution {

    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int stone : stones) {
            cnt[stone % 3]++;
        }

        if (cnt[0] % 2 == 0) {
            if(cnt[1] == 0 || cnt[2] == 0) return false;
            else return true;
        }
        else {
            if (Math.abs(cnt[1] - cnt[2]) <= 2) return false;
            else return true;
        }
    }

}
