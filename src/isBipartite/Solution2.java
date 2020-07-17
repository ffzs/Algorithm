package isBipartite;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/16
 */
public class Solution2 {
    static int[] step;
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        step = new int[n];
        for (int i = 0; i < n; i++) {
            if (step[i] == 0) {
                if (!dfs(i, 1, graph)) return false;
            }
        }
        return true;
    }

    private static boolean dfs(int i, int c, int[][] graph) {
        step[i] = c;
        for (int i1 : graph[i]) {
            if (step[i1] == 0) {
                if (!dfs(i1, -c, graph)) return false;
            }
            else if (step[i1] != -c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}
