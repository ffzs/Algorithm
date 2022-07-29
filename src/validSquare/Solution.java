package validSquare;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2022/7/29 下午12:36
 */
public class Solution {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int a = dis(p1, p2), b = dis(p1, p3), c = dis(p1, p4);
        if (a == 0 || b == 0 || c == 0) return false;
        if (a == b && c == 2 * a) {
            int d = dis(p2, p4);
            return a == d && d == dis(p3, p4) && c == dis(p2, p3);
        }
        else if (a == c && b == 2 * a) {
            int d = dis(p2 ,p3);
            return a == d && d == dis(p3, p4) && b == dis(p2, p4);
        }
        else if (b == c && a == 2 * b) {
            int d = dis(p2, p3);
            return d == b && d == dis(p2, p4) && a == dis(p3, p4);
        }
        return false;
    }

    private int dis(int[] p1, int[] p2) {
        int a = p1[0] - p2[0], b = p1[1] - p2[1];
        return a * a + b * b;
    }

}
