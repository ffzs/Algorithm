package oddCells;

/**
 * @author: ffzs
 * @Date: 2022/7/12 上午9:01
 */
public class Solution {

    public int oddCells(int m, int n, int[][] indices) {
        int[] cm = new int[m], cn = new int[n];
        for (int[] index : indices) {
            cm[index[0]] += 1;
            cn[index[1]] += 1;
        }

        int odd = 0, even = 0, res = 0;
        for (int i : cn) {
            if ((i & 1) == 1) odd += 1;
            else even += 1;
        }
        for (int i : cm) {
            if ((i & 1) == 1) res += even;
            else res += odd;
        }
        return res;
    }


}
