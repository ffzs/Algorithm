package boxDelivering;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/12/5 上午11:50
 */
public class Solution {

    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] f = new int[n + 1];
        f[1] = 2;
        int diff = 2;
        int wt = boxes[0][1];
        int l = 0;
        for (int i = 1; i < n; i++) {
            wt += boxes[i][1];
            if (boxes[i][0] != boxes[i - 1][0]) diff += 1;
            while (wt > maxWeight || i - l + 1 > maxBoxes || f[l] == f[l + 1]) {
                wt -= boxes[l][1];
                if (boxes[l][0] != boxes[l + 1][0]) diff -= 1;
                l += 1;
            }
            f[i + 1] = f[l] + diff;
        }
        return f[n];
    }

}
