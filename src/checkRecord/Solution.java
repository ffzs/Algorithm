package checkRecord;

/**
 * @author: ffzs
 * @Date: 2021/8/17 上午6:54
 */
public class Solution {

    public boolean checkRecord(String s) {
        int A = 0;
        int L = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            while (i < cs.length && cs[i] == 'L') {
                L++;
                i++;
            }
            if (L >= 3) return false;
            else L = 0;

            if (i < cs.length && cs[i] == 'A') {
                A ++;
                if (A >= 2) return false;
            }
        }
        return true;
    }

}
