package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/6/22 上午6:57
 */
public class Solution {
    char[] sc;
    int n;
    boolean[] visited;
    List<String> lst = new ArrayList<>();
    public String[] permutation(String s) {
        sc = s.toCharArray();
        Arrays.sort(sc);
        n = sc.length;
        visited = new boolean[n];
        dfs(0, new StringBuilder());
        return lst.toArray(new String[0]);
    }

    private void dfs(int idx, StringBuilder sb) {
        if(idx == n) {
            lst.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            else if (i >= 1 && !visited[i-1] && sc[i-1] == sc[i]) continue;

            visited[i] = true;
            sb.append(sc[i]);
            dfs(idx + 1, sb);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }
}
