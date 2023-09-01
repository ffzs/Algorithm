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
            if (forts[i] == 1) {
                int j = i+1;
                while (j < n && forts[j] == 0) j++;
                if (j == n) break;
                if (forts[j] == -1) res = Math.max(j-i, res);
                i = j-1;
            }

            if (forts[i] == -1) {
                int j = i+1;
                while (j < n && forts[j] == 0) j++;
                if (j == n) break;
                if (forts[j] == 1) res = Math.max(j-i, res);
                i = j-1;
            }

            i++;
        }

        return res;
    }

}
