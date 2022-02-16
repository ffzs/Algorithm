package checkWays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/2/16 上午8:48
 */
public class Solution {

    public int checkWays(int[][] pairs) {
        boolean[][] edges = new boolean[501][501];
        int[] cnt = new int[501];
        int max = 0;
        for (int[] p : pairs) {
            cnt[p[0]]++;
            cnt[p[1]]++;
            edges[p[0]][p[1]] = true;
            edges[p[1]][p[0]] = true;
        }
        List<Integer> lst = new ArrayList<>();
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                lst.add(i);
                max = i;
            }
        }
        lst.sort((a, b) -> cnt[b] - cnt[a]);

        if (cnt[lst.get(0)] < lst.size() - 1) return 0;
        int[] father = new int[max+1];
        father[lst.get(0)] = -1;
        for (int i = 1; i < lst.size(); i++) {
            int x = lst.get(i);
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                int y = lst.get(j);
                if (edges[x][y]) {
                    father[x] = y;
                    flag = true;
                    break;
                }
            }
            if (!flag) return 0;
        }
        int res = 1, c = 0;
        for (int i : lst) {
            int j = i;
            while (father[j] != -1) {
                if (!edges[i][father[j]]) return 0;
                if (cnt[i] == cnt[father[j]]) res = 2;
                c++;
                j = father[j];
            }
        }
        return c < pairs.length ? 0 : res;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {1,3}};
        Solution s = new Solution();
        System.out.println(s.checkWays(pairs));
    }
}
