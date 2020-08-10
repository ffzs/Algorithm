package countBinarySubstrings;

/**
 * @author: ffzs
 * @Date: 2020/8/10 上午8:00
 */
public class Solution2 {

    public int countBinarySubstrings(String s) {
        int len = s.length();
        int res = 0, count0 = 0, count1 = 0;
        boolean is0 = true;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                if (!is0){
                    is0 = true;
                    count0 = 0;
                }
                count0 ++;
                if (count0 <= count1) res ++;
            }
            else {
                if (is0){
                    is0 = false;
                    count1 = 0;
                }
                count1++;
                if (count1 <= count0) res ++;
            }
        }
        return res;
    }
}
