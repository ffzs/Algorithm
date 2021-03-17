package numDistinct;

/**
 * @author: ffzs
 * @Date: 2021/3/17 上午7:23
 */
public class Solution {

    char[] tc, sc, tmp;
    int n;
    int res = 0;
    public int numDistinct(String s, String t) {
        sc = s.toCharArray();
        tc = t.toCharArray();
        n = tc.length;
        tmp = new char[n];

        dfs(0, 0);

        return res;
    }

    private void dfs(int i, int c) {
        if (c >= n) {
            if (equal(tmp, tc)) res ++;
            return;
        }

        for (int j = i; j < sc.length; j++) {
            if(sc[j] == tc[c]) {
                tmp[c] = sc[j];
                dfs(j + 1, c + 1);
            }
        }
    }


    private boolean equal (char[] a, char[] b) {
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

}
