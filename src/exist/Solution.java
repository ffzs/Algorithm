package exist;

/**
 * @author: ffzs
 * @Date: 2020/9/13 上午7:07
 */
public class Solution {
    int n, m;
    char[][] step;
    char[] seq;
    boolean isExist = false;
    int[][] direction = {{1,0}, {-1,0}, {0, 1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        step = board;
        seq = word.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isExist && seq[0] == step[i][j]) {
                    step[i][j] = '#';
                    dfs (1, i, j);
                    step[i][j] = seq[0];
                }
            }
        }
        return isExist;
    }


    private void dfs (int index, int i, int j) {
        if (!isExist) {
            if (index == seq.length) {
                isExist = true;
                return;
            }
            for (int[] dt : direction) {
                int ii = dt[0]+i;
                int jj = dt[1]+j;
                if (inRule(ii, jj) && step[ii][jj]== seq[index]) {
                    step[ii][jj] = '#';
                    dfs(index+1, ii, jj);
                    step[ii][jj] = seq[index];
                }
            }
        }
    }

    private boolean inRule (int i, int j) {
        return i>=0 && i<n && j>=0 && j<m;
    }
}

class Test {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        Solution solution = new Solution();
        System.out.println(solution.exist(board, "ABCCED"));
    }
}
