package strStr;

/**
 * @author: ffzs
 * @Date: 2021/4/20 上午8:23
 */
public class Solution2 {
    public int strStr(String haystack, String needle) {
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        if (n.length == 0) return 0;

        for (int i = 0; i < h.length - n.length + 1; i++) {
            m:if (h[i] == n[0]) {
                for (int j = 1; j < n.length; j++) {
                    if (n[j] != h[i+j]) break m;
                }
                return i;
            }
        }

        return -1;
    }
}
