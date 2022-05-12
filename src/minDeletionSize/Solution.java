package minDeletionSize;

/**
 * @author: ffzs
 * @Date: 2022/5/12 上午8:49
 */
public class Solution {

    public int minDeletionSize(String[] strs) {
        int res = 0;
        int m = strs.length, n = strs[0].length();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (strs[j].charAt(i) < strs[j-1].charAt(i)) {
                    ++res;
                    break;
                }
            }
        }

        return res;
    }

}
