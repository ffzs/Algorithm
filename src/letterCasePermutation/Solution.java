package letterCasePermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/10/30 下午2:48
 */
public class Solution {
    List<String> res;
    int gap = 'a' - 'A';
    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'a' && cs[i] <= 'z') cs[i] = (char)(cs[i] - gap);
        }
        dfs(cs, 0);
        return res;
    }

    private void dfs (char[] cs, int idx) {
        res.add(new String(cs));
        for (int i = idx; i < cs.length; i++) {
            if (cs[i] > 'Z' || cs[i] < 'A') continue;
            char c = cs[i];
            cs[i] = (char)(c + gap);
            dfs(cs, i + 1);
            cs[i] = c;
        }
    }

}
