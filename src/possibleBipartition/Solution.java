package possibleBipartition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/10/16 下午6:54
 */
public class Solution {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colors = new int[n + 1];
        List<Integer>[] f = new List[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            f[dislike[0]].add(dislike[1]);
            f[dislike[1]].add(dislike[0]);
        }
        for (int i = 0; i < n; i++) {
            if (colors[i + 1] == 0 && !dfs(i + 1, 1, colors, f)) return false;
        }
        return true;
    }

    private boolean dfs (int cur, int color, int[] colors, List<Integer>[] f) {
        colors[cur] = color;
        for (int it : f[cur]) {
            if (colors[it] != 0 && colors[it] == colors[cur]) return false;
            if (colors[it] == 0 && ! dfs(it, 3 ^ color, colors, f)) return false;
        }
        return true;
    }

}
