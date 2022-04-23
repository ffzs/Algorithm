package outerTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/4/23 上午8:27
 */
public class Solution {

    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;

        if (n < 4) return trees;

        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        int[] lst = new int[n << 1];

        int si = 0;
        for (int i = 0; i < n; i++) {
            while (si > 1 && ban(trees[lst[si - 2]], trees[lst[si - 1]], trees[i])) {
                --si;
            }
            lst[si++] = i;
        }

        for (int i = n - 2; i >= 0; i--) {
            while (si > 1 && ban(trees[lst[si - 2]], trees[lst[si - 1]], trees[i])) {
                --si;
            }
            lst[si++] = i;
        }
        Arrays.sort(lst, 0, si);
        int size = 1;
        for (int i = 1; i < si; i++) {
            if (lst[i-1] != lst[i]) ++size;
        }
        int[][] res = new int[size][2];
        for (int i = 0, j = 0; i < si && j < size; i++) {
            if (lst[i] != lst[i + 1]) res[j++] = trees[lst[i]];
        }
        return res;
    }

    private boolean ban (int[] p1, int[] p2, int[] p3) {
        return ((p2[0] - p1[0]) * (p3[1] - p2[1]) - (p2[1] - p1[1]) * (p3[0] - p2[0])) < 0;
    }

}
