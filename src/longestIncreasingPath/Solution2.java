package longestIncreasingPath;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2020/7/26 上午8:52
 */
public class Solution2 {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] inDegree = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int count = 0;
                for (int[] direction : directions) {
                    int ii = i + direction[0], jj = j + direction[1];
                    if (ii>=0 && ii<n && jj>=0 && jj<m && matrix[ii][jj]>matrix[i][j]) count ++;
                }
                if (count == 0) queue.add(new int[]{i, j});
                inDegree[i][j] = count;
            }
        }

        int res = 0;
        while(!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] item = queue.poll();
                for (int[] direction : directions) {
                    int ii = item[0] + direction[0], jj = item[1] + direction[1];
                    if (ii >= 0 && ii < n && jj >= 0 && jj < m && matrix[ii][jj] < matrix[item[0]][item[1]]){
                        --inDegree[ii][jj];
                        if (inDegree[ii][jj] == 0) queue.add(new int[]{ii, jj});
                    }
                }
            }
        }
        return res;
    }
}

class Test2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
        System.out.println(solution2.longestIncreasingPath(matrix));
    }
}
