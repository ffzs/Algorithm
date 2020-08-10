package countBinarySubstrings;

/**
 * @author: ffzs
 * @Date: 2020/8/10 上午7:31
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isBinary(chars, i)) res++;
        }
        return res;
    }

    private boolean isBinary (char[] c, int i) {
        int count = 0;
        char first = c[i];
        while(i < c.length && c[i] == first) {
            count++;
            i++;
        }
        while (i < c.length && c[i] != first) {
            count--;
            i++;
        }
        return count <= 0;
    }
}
