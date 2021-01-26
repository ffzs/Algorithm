package numEquivDominoPairs;

/**
 * @author: ffzs
 * @Date: 2021/1/26 下午8:02
 */
public class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] tmp = new int[10][10];

        for (int[] dominoe : dominoes) {
            int i = dominoe[0], j = dominoe[1];

            if (i > j) {
                tmp[j][i] ++;
            }
            else{
                tmp[i][j] ++;
            }
        }

        int res = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i; j < 9; j++) {
                int v = tmp[i][j];
                if (v >= 2) res += sum(v);
            }
        }

        return res;
    }

    private int sum (int i) {
        return ((i-1) * i) / 2;
    }

}
