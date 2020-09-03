package solveNQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/3 上午7:39
 */
public class Solution {

    int[][] step;
    List<List<String>> res = new ArrayList<>();
    int[] count;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.step = new int[n][n];
        this.count = new int[n];
        dfs(0);
        return res;
    }

    private void dfs (int r) {
        if (r==n){
            res.add(transTable());
            return;
        }
        for (int i = 0; i < n; i++) {
            // 保存状态
            if (step[r][i]==0) {
                int[][] tmp = deepCopy(step);
                int[] tmpCount = Arrays.copyOf(count, n);
                if (fillArray(r, i)) {
                    dfs(r+1);
                }
                step = tmp;
                count = tmpCount;
            }
        }
    }

    private boolean fillArray (int r, int i) {
//
        for (int j = r; j < n; j++) {
            if (j==r) {
                Arrays.fill(step[r], 1);
                step[r][i] = -1;
                count[r] = n;
            }else{
                for (int k = 0; k < n; k++) {
                    if ((k==i || k==i-(j-r) || k==i+(j-r))&&step[j][k]==0) {
                        step[j][k] = 1;
                        if (count[j] <= n) count[j]++;
                        else return false;
                    }
                }
            }
        }
        return true;
    }

    private List<String> transTable () {
        List<String> ret = new ArrayList<>();
        for (int[] ints : step) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < step.length; j++) {
                if (ints[j] == -1) s.append('Q');
                else if (ints[j] == 1) s.append('.');
            }
            ret.add(s.toString());
        }
        return ret;
    }

    private int[][] deepCopy (int[][] reference) {
        int[][] copy = new int[reference.length][reference.length];
        for (int i = 0; i < reference.length; i++) {
            System.arraycopy(reference[i], 0, copy[i], 0, reference.length);
        }
        return copy;
    }
}

class Test {
    public static void main(String[] args) {
        int row = 5;
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(row));
    }
}
