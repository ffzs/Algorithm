package checkRecord2;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/8/18 上午6:54
 * 1: A
 * 2: L
 * 3: P
 */
public class Solution {

    int res = 0;
    public int checkRecord(int n) {
        int[] tmp = new int[n];
        dfs(tmp, 0, 0);
        return res;
    }


    private void dfs(int[] t, int i, int A){
        if (A >= 2 || (i-2>0 && t[i-1] == 2 && t[i-2] == 2 && t[i-3] == 2)) return;
        if (i == t.length){
            res ++;
            return;
        }

        for (int j = 1; j <= 3; j++) {
            t[i] = j;
            dfs(t, i + 1, j == 1? A+1 : A);
        }
    }

}
