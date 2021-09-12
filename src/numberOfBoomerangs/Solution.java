package numberOfBoomerangs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/9/13 上午6:50
 */
public class Solution {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int diffX = points[i][0] - points[j][0];
                int diffY = points[i][1] - points[j][1];
                int len = diffX * diffX + diffY * diffY;
                int cnt = map.getOrDefault(len, 0);
                res += cnt;
                map.put(len, cnt + 1);
            }
            map.clear();
        }

        return res*2;
    }

}
