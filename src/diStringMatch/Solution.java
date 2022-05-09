package diStringMatch;

/**
 * @author: ffzs
 * @Date: 2022/5/9 上午8:56
 */
public class Solution {

    public int[] diStringMatch(String s) {
        int n = s.length() + 1;
        int[] res = new int[n];
        int l = 0, r = 0, i = 1;
        for (char c : s.toCharArray()) {
            if (c == 'I') {
                res[i] = ++r;
            }else {
                res[i] = --l;
            }
            ++i;
        }
        for (int j = 0; j < n; j++) {
            res[j] -= l;
        }
        return res;
    }

}
