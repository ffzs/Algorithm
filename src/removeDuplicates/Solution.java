package removeDuplicates;

/**
 * @author: ffzs
 * @Date: 2021/3/9 上午7:53
 */
public class Solution {

    public String removeDuplicates(String S) {
        char[] cs = S.toCharArray();
        int n = cs.length;
        boolean[] tmp = new boolean[n];
        boolean flag = false;

        for (int i = 1; i < n; i++) {
            if (cs[i] == cs[i-1] && !tmp[i] && !tmp[i-1]) {
                int l = i-1, r = i;
                while (l>=0 && r < n && cs[l] == cs[r] && !tmp[l] && !tmp[r]) {
                    tmp[l--] = true;
                    tmp[r++] = true;
                    flag = true;
                }
            }
        }

        if (!flag) return S;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!tmp[i]) sb.append(cs[i]);
        }

        return removeDuplicates(sb.toString());
    }

}
