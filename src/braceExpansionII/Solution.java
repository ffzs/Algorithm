package braceExpansionII;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author: ffzs
 * @Date: 2023/3/7 上午9:17
 */
public class Solution {
    TreeSet<String> set = new TreeSet<>();
    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(set);
    }

    private void dfs (String s) {
        int j = s.indexOf('}');
        if (j == -1) {
            set.add(s);
            return;
        }

        int i = j - 1;
        while (s.charAt(i) != '{') i -= 1;

        String pre = s.substring(0, i);
        String suf = s.substring(j+1);
        for (String mid : s.substring(i + 1, j).split(",")) {
            dfs(pre + mid + suf);
        }
    }

}
