package findCircleNum;

/**
 * @author: ffzs
 * @Date: 2021/1/7 下午7:49
 */
public class Solution2 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            res += dps(isConnected, i, visited);
        }

        return res;
    }

    private int dps(int[][] isConnected, int i, boolean[] visited) {
        if (visited[i]) return 0;
        else {
            visited[i] = true;
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    dps(isConnected, j, visited);
                }
            }
            return 1;
        }
    }
}
