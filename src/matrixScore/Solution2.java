package matrixScore;

/**
 * @author: ffzs
 * @Date: 2020/12/7 上午8:39
 */
public class Solution2 {
    public int matrixScore(int[][] A) {
        int res = 0;

        for (int i = 0; i < A[0].length; i++) {
            int ones = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][0] == 1) ones += A[j][i];
                else ones += (1 - A[j][i]);
            }
            if (ones < A.length - ones) ones = A.length - ones;
            res += ones * (1<<(A[0].length - i - 1));
        }

        return res;
    }
}
