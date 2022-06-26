package pickBlackList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author: ffzs
 * @Date: 2022/6/26 上午9:12
 */
public class Solution {
    int white;
    List<int[]> intervals = new ArrayList<>();
    Random r = new Random();
    public Solution(int n, int[] blacklist) {
        white = n - blacklist.length;
        Arrays.sort(blacklist);
        if (n == 1 || blacklist.length == 0) {
            intervals.add(new int[]{n, 0});
        }
        else {
            if (blacklist[0] != 0) intervals.add(new int[] {blacklist[0], 0});
            for (int i = 0; i < blacklist.length-1; i++) {
                if (blacklist[i] == blacklist[i+1]-1) continue;
                intervals.add(new int[] {blacklist[i+1] - blacklist[i] - 1, blacklist[i] + 1});
            }
            if (blacklist[blacklist.length-1] != n-1) intervals.add(new int[]{n - 1 - blacklist[blacklist.length-1], blacklist[blacklist.length-1] + 1});

        }
    }

    public int pick() {
        int idx = r.nextInt(white);
        for (int[] interval : intervals) {
            if (idx < interval[0]) return interval[1] + idx;
            idx -= interval[0];
        }
        return -1;
    }

}
