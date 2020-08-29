package shortestPalindrome;

/**
 * @author: ffzs
 * @Date: 2020/8/29 上午9:58
 */
public class Solution3 {
    public String shortestPalindrome(String s) {
        char[] seq = s.toCharArray();

        int i=0;
        for (int j = seq.length-1; j >= 0; --j) {
            if (seq[i] == seq[j]) i++;
        }
        if (i == seq.length) return s;
        StringBuilder res = new StringBuilder(s.substring(i));
        res = res.reverse();
        return res.append(shortestPalindrome(s.substring(0,i))).append(s.substring(i)).toString();
    }
}
