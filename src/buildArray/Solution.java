package buildArray;

import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/10/15 下午1:35
 */
public class Solution {
    static final String PUSH = "Push", POP = "Pop";
    public List<String> buildArray(int[] target, int n) {
        int j = 0;
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(PUSH);
            if (target[j] == i) {
                j += 1;
            }
            else res.add(POP);
            if (j == target.length) break;
        }
        return res;
    }

}
