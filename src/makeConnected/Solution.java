package makeConnected;

import java.net.Socket;
import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/1/23 上午9:09
 */
class UniFind {

    private int[] f;

    public UniFind(int n) {
        f = new int[n];
        for (int i = 0; i < n; i++) f[i] = i;
    }

    public int find (int i) {
        if (f[i] != i) f[i] = find(f[i]);
        return f[i];
    }

    public void union (int i, int j) {
        f[find(i)] = find(j);
    }
}

public class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (n > connections.length + 1) return -1;

        UniFind uni = new UniFind(n);
        for (int[] con : connections) {
            if (uni.find(con[0]) != uni.find(con[1])) {
                uni.union(con[0], con[1]);
            }
        }
        boolean[] step = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int fa = uni.find(i);
            if (! step[fa]) {
                step[fa] = true;
                res ++ ;
            }
        }
        return res - 1;
    }
}

class Test {
    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0,1},{0,2},{1,2}};
        Solution solution = new Solution();
        System.out.println(solution.makeConnected(n, connections));
    }
}
