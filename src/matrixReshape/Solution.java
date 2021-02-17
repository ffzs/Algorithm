package matrixReshape;

/**
 * @author: ffzs
 * @Date: 2021/2/17 上午9:18
 */
public class Solution {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;

        if (r*c != m*n) return nums;

        int[][] res = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i*n + j;
                res[index/c][index%c] = nums[i][j];
            }
        }
        return res;
    }

}
