package removePalindromeSub;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/1/22 上午7:38
 */
public class Solution {

    public int removePalindromeSub(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return 2;
        }
        return 1;
    }

}
