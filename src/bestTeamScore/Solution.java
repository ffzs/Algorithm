package bestTeamScore;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/3/22 上午8:27
 */
public class Solution {
    int maxAge = 0;
    int[] tree;
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] info = new int[n][2];
        for (int i = 0; i < n; i++) {
            info[i] = new int[] {scores[i], ages[i]};
            maxAge = Math.max(maxAge, ages[i]);
        }
        tree = new int[maxAge+1];
        Arrays.sort(info, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = info[i][0] + find(info[i][1]);
            update(info[i][1], cur);
            res = Math.max(res, cur);
        }
        return res;
    }

    private int lowBit(int i) {
        return i & (-i);
    }

    private void update (int age, int score) {
        while (age <= maxAge) {
            tree[age] = Math.max(tree[age], score);
            age += lowBit(age);
        }
    }

    private int find (int age) {
        int ret = 0;
        while (age > 0) {
            ret = Math.max(tree[age], ret);
            age -= lowBit(age);
        }
        return ret;
    }

}
