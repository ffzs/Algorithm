package partition2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/3/7 下午1:40
 */
public class Solution {
    int[][] f;
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    int n;


    public List<List<String>> partition(String s) {
        n = s.length();
        f = new int[n][n];

        dfs(s, 0);

        return res;
    }

    private void dfs(String s, int i) {
        if (i == n) {
            res.add(new ArrayList<>(list));
        }
        else {
            for (int j = i; j < n; j++) {
                if (isValid(s, i, j) == 1) {
                    list.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private int isValid(String s, int i, int j) {
        if (f[i][j] != 0) return f[i][j];

        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isValid(s, i + 1, j - 1);
        } else f[i][j] = -1;

        return f[i][j];
    }

}
