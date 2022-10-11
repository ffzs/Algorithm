package areAlmostEqual;

/**
 * @author: ffzs
 * @Date: 2022/10/11 下午6:15
 */
public class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length(), cnt = 0, a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (cnt == 0) {
                    a = s1.charAt(i);
                    b = s2.charAt(i);
                    cnt += 1;
                }
                else if (cnt == 1) {
                    c = s1.charAt(i);
                    d = s2.charAt(i);
                    cnt += 1;
                }
                else if (cnt >= 2) return false;
            }
        }
        return cnt == 0 || cnt == 2 && a == d && b == c;
    }
}
