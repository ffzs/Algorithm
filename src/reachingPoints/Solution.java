package reachingPoints;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2022/4/9 上午8:29
 */
public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx < sx || ty < sy) return false;
        if (tx > sx && ty > sy) {
            if (ty == tx) return false;
            else if (tx > ty) return reachingPoints(sx, sy, tx % ty, ty);
            else return reachingPoints(sx, sy, tx, ty % tx);
        }
        else if (tx == sx) return (ty - sy) % sx == 0;
        else return (tx - sx) % sy == 0;
    }

}
