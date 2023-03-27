package countSubstrings2;

/**
 * @author: ffzs
 * @Date: 2023/3/27 下午1:55
 */
public class Solution {

    public int countSubstrings(String s, String t) {
        int res = 0, same;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                same = 0;
                for (int k = 0; k + i < s.length() && k + j < t.length(); k++) {
                    if (s.charAt(i + k) != t.charAt(j + k)) same += 1;
                    if (same > 1) break;
                    else if (same == 1) res += 1;
                }
            }
        }
        return res;
    }

}
