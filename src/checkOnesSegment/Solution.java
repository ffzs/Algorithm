package checkOnesSegment;

/**
 * @author: ffzs
 * @Date: 2022/10/3 下午12:03
 */
public class Solution {

    public boolean checkOnesSegment(String s) {
        int cnt = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0;
        while (i < n) {
            if (cs[i] == '1') {
                cnt += 1;
                while (i < n && cs[i] == '1') i += 1;
            }
            i += 1;
        }
        return cnt == 1;
    }

}
