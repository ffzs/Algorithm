package truncateSentence;

/**
 * @author: ffzs
 * @Date: 2021/12/6 上午7:25
 */
public class Solution {

    public String truncateSentence(String s, int k) {
        int i = 0, n = s.length();
        char[] cs = s.toCharArray();
        while (k > 0) {
            while (i < n && cs[i] != ' ') i++;
            k--;
            i++;
        }
        return s.substring(0, i-1);
    }

}
