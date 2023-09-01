package captureForts;

/**
 * @author: ffzs
 * @Date: 2023/9/2 上午6:49
 */
public class Solution {

    public int captureForts(int[] forts) {
        int n = forts.length;
        int i = 0;
        int res = 0;
        while (i < n) {
            while (i < n && forts[i] == 0) i++;
            if (i == n) break;
            int j = i+1;
            while (j < n && forts[j] == 0) j++;
            if (j == n) break;
            if (forts[j] * forts[i] == -1) res = Math.max(j-i-1, res);
            i = j;
        }

        return res;
    }

}
