package pushDominoes;

/**
 * @author: ffzs
 * @Date: 2022/2/21 上午9:38
 */
public class Solution {

    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        int l = 0;
        char left = 'L';
        while (l < n) {
            int r = l;
            while (r < n && cs[r] == '.') r++;
            char right = r < n ? cs[r] : 'R';
            if  (left == right) {
                while (l < r) cs[l++] = left;
            }
            else if (left == 'R' && right == 'L') {
                int m = r - 1;
                while (l < m) {
                    cs[l++] = 'R';
                    cs[m--] = 'L';
                }
            }
            left = right;
            l = r + 1;
        }
        return new String(cs);
    }

}
