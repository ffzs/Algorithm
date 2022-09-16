package rectangleArea;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2022/9/16 上午11:29
 */
public class Solution {
    static final int MOD = (int)1e9 + 7;
    public int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
        Set<Integer> set = new HashSet<>();
        for (int[] rect : rectangles) {
            set.add(rect[1]);
            set.add(rect[3]);
        }
        int[] ySeq = new int[set.size()];
        int h = 0;
        for (int i : set) {
            ySeq[h++] = i;
        }
        Arrays.sort(ySeq);
        int[] cnt = new int[ySeq.length - 1];
        int[][] sweep = new int[n<<1][3];
        for (int i = 0, j = 0; i < n; i++) {
            sweep[j++] = new int[]{rectangles[i][0], i, 1};
            sweep[j++] = new int[]{rectangles[i][2], i, -1};
        }
        Arrays.sort(sweep, (a,b)-> {
            if (a[0] != b[0]) return a[0] - b[0];
            else if (a[1] != b[1]) return a[1] - b[1];
            else return a[2] - b[2];
        });

        long res = 0;
        int m = sweep.length, i = 0, j;
        while (i < m) {
            j = i + 1;
            while (j < m && sweep[i][0] == sweep[j][0]) j += 1;
            if (j == m) break;
            for (int k = i; k < j; k++) {
                int idx = sweep[k][1], l = rectangles[idx][1], r= rectangles[idx][3];
                // 可改为二分法找到范围
                for (int x = 0; x < ySeq.length-1; x++) {
                    if (l <= ySeq[x] && ySeq[x+1] <= r) cnt[x] += sweep[k][2];
                }
            }
            int ySum = 0;
            for (int k = 0; k < ySeq.length-1; k++) {
                if (cnt[k] > 0) ySum += ySeq[k + 1] - ySeq[k];
            }

            res += (long) ySum * (sweep[j][0] - sweep[i][0]);
            i = j;
        }
        return (int) (res % MOD);
    }

}
