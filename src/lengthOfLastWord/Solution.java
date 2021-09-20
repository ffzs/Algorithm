package lengthOfLastWord;

import com.sun.security.jgss.GSSUtil;

/**
 * @author: ffzs
 * @Date: 2021/9/21 上午6:55
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        char[] cs = s.toCharArray();
        int cnt = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] != ' ') cnt++;
            else if (cnt != 0) return cnt;
        }
        return cnt;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord("Today is a nice day"));
    }
}
