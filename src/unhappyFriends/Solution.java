package unhappyFriends;


/**
 * @author: ffzs
 * @Date: 2021/8/14 上午7:05
 */
public class Solution {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        boolean[][] like = new boolean[n][n];
        for (int[] pair : pairs) {
            compare(like, preferences, pair[0], pair[1]);
            compare(like, preferences, pair[1], pair[0]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (like[i][j] && like[j][i]) {
                    res ++;
                    break;
                }
            }
        }
        return res;
    }

    private void compare(boolean[][] like, int[][] preferences, int x, int y) {
        for (int i = 0; i < preferences.length && preferences[x][i] != y; i++) {
            like[x][preferences[x][i]] = true;
        }
    }
}
