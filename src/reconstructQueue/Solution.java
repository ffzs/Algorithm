package reconstructQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/11/16 上午11:16
 */
public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> tmp = new ArrayList<>();
        for (int[] p : people) {
            tmp.add(p[1], p);
        }
        return tmp.toArray(new int[tmp.size()][]);
    }
}
