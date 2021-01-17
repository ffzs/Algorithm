package checkStraightLine;

/**
 * @author: ffzs
 * @Date: 2021/1/17 下午5:20
 */
public class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n <= 2) return true;


        for (int i = 1; i < n-1; i++) {
            if ((coordinates[i+1][1] - coordinates[i][1])*(coordinates[i][0] - coordinates[i-1][0]) != (coordinates[i][1] - coordinates[i-1][1])*(coordinates[i+1][0] - coordinates[i][0])) {
                return false;
            }
        }
        return true;
    }
}
