package distributeCandies;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/11/1 上午7:26
 */
public class Solution {

    public int distributeCandies(int[] candyType) {
        boolean[] tmp = new boolean[200001];
        int cnt = 0;
        for (int i : candyType) {
            int cur = i+100000;
            if (!tmp[cur]) {
                cnt++;
                tmp[cur] = true;
            }
            else tmp[i+100000] = true;
        }
        return Math.min(cnt, candyType.length / 2);
    }

}
