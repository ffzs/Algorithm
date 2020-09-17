package findRedundantDirectedConnection;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/9/17 上午7:04
 */

public class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        int[] tmp = new int[n+1];
        int[] step = new int[n+1];
        int[] aim = {0,0};
        int[] circle = {0,0};
        for (int[] edge : edges) {
            if (tmp[edge[1]] == 0) {
                tmp[edge[1]] = edge[0];
            }else aim = edge;

            if (step[edge[0]] == 0) {
                step[edge[0]] = edge[1];
            }
            if (step[edge[1]] != 0) circle = edge;
        }

        if (circle[0] == 0) {
            return aim;
        }
        if (aim[0] == 0) {
            return circle;
        }
        int start = tmp[aim[1]];
        while (true) {
            start = tmp[start];
            if (start == 0) break;
            if (start == aim[1]) return new int[] {tmp[aim[1]], aim[1]};
        }
        return aim;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{2,1},{3,1},{4,2},{1,4}};
        System.out.println(Arrays.toString(solution.findRedundantDirectedConnection(edges)));
    }
}
