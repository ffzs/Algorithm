package lastSubstring;

/**
 * @author: ffzs
 * @Date: 2023/4/24 上午9:04
 */
public class Solution {

    public String lastSubstring(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0, j = 1, k = 0;
        while (j < n) {
            if (cs[i] > cs[j]) j += 1;
            else if (cs[j] > cs[i]) i = j++;
            else {
                k = 1;
                while (j + k < n && cs[i + k] == cs[j + k]) k++;
                if (j + k == n) break;
                if (cs[i + k] > cs[j + k]) {
                    j += k + 1;
                }
                else if (cs[i] < cs[j + k]) {
                    i = j + k;
                    j = i + 1;
                }
                else i = j ++;
            }
        }
        return s.substring(i);
    }

}
