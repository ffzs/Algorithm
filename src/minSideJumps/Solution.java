package minSideJumps;

/**
 * @author: ffzs
 * @Date: 2023/1/21 上午9:50
 */
public class Solution {

    public int minSideJumps(int[] obstacles) {
        int[] open = {0, 0, 1, 0};
        int res = 0, cnt = 1;
        for (int i = 1; i < obstacles.length; i++) {
            int v = obstacles[i];
            if (open[v] == 1) {
                if (cnt == 2) {
                    cnt = 1;
                    open[v] = 0;
                }
                else {
                    cnt = 0;
                    for (int j = 1; j <= 3; j++) {
                        if (j == v || obstacles[i-1] == j) {
                            open[j] = 0;
                            continue;
                        }
                        open[j] = 1;
                        cnt += 1;
                    }
                    res += 1;
                }
            }
        }
        return res;
    }

}
