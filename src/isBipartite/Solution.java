package isBipartite;

/**
 * @author ffzs
 * @describe 染色法
 * @date 2020/7/16
 */
public class Solution {
    static int[] step;
    static boolean valid = true;
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        step = new int[n];
        for (int i = 0; i < n && valid; i++) {
            if (step[i] == 0) {
                dfs(i, 1, graph);
            }
        }
        return valid;
    }

    private static void dfs(int i, int c, int[][] graph) {
        step[i] = c;
        for (int i1 : graph[i]) {
            if (step[i1] == 0) {
                dfs(i1, -c, graph);
                if (!valid) return;
            }
            else if (step[i1] != -c) {
                valid = false;
                return;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}
