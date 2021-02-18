package minKBitFlips;

/**
 * @author: ffzs
 * @Date: 2021/2/18 上午9:04
 */
public class Solution {

    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int res = 0, cnt = 0;
        int[] diff = new int[n+1];

        for (int i = 0; i < n; i++) {
            cnt += diff[i];
            if ((A[i] + cnt) % 2 == 0) {
                if (i + K > n) return -1;
                res++;
                cnt++;
                diff[i+K]--;
            }
        }

        return res;
    }

}
