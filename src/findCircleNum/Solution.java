package findCircleNum;

/**
 * @author: ffzs
 * @Date: 2021/1/7 下午7:48
 */
public class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][k] == 1 && isConnected[k][j] == 1) {
                        isConnected[i][j] = 1;
                    }
                }
            }
        }
        int res = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]){
                visited[i] = true;
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1) visited[j] = true;
                }
                res++;
            }
        }
        return res;
    }

}
