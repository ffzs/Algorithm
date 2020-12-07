package matrixScore;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/12/7 上午8:04
 */
public class Solution {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) turnRow(A[i]);
        }

        for (int i = 1; i < A[0].length; i++) {
            turnColumn(A, i);
        }

        System.out.println(Arrays.deepToString(A));
        int res = 0;
        for (int[] ints : A) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] != 0) res += 1<<(ints.length - i - 1);
            }
        }
        return res;
    }

    private void turnRow(int[] row){
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) row[i] = 1;
            else row[i] = 0;
        }
    }

    private void turnColumn(int[][] m, int col) {
        int count = 0;
        for (int[] ints : m) {
            if (ints[col] == 1) count++;
        }
        if (count >= m.length-count) return;
        for (int[] ints : m) {
            if (ints[col] == 0) ints[col] = 1;
            else ints[col] = 0;
        }
    }
}
