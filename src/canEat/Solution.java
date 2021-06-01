package canEat;

/**
 * @author: ffzs
 * @Date: 2021/6/1 上午7:28
 */
public class Solution {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] tmp = new long[candiesCount.length+1];
        for (int i = 0; i < tmp.length-1; i++) {
            tmp[i+1] = tmp[i] + candiesCount[i];
        }

        boolean[] res = new boolean[queries.length];

        int i = 0;
        for (int[] query : queries) {
            int fav = query[0], day = query[1] + 1, daily = query[2];
            // (tmp[fav], tmp[fav+1]] [day, day*daily]
            long max = (long)day*daily;
            res[i++] = !(tmp[fav+1]<=day||tmp[fav]>max);
        }

        return res;
    }

}
