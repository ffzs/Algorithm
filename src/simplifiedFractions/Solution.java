package simplifiedFractions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/2/10 上午8:57
 */
public class Solution {

    public List<String> simplifiedFractions(int n) {
        boolean[][] ban = new boolean[n+1][n+1];
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (!ban[i][j]) res.add(new StringBuilder(i).append('/').append(j).toString());
                for (int k = 2; k * i <= n; k++) {
                    ban[k*i][k*j] = true;
                }
            }
        }
        return res;
    }

}
