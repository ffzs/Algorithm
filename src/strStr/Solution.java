package strStr;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/4/20 上午7:59
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        if (n.length == 0) return 0;
        int[] tmp = new int[h.length];
        Arrays.fill(tmp, -1);
        for (int i = 0; i < n.length; i++) {
            for (int j = h.length-1; j >= 0; --j) {
                if (i==0) {
                    if (n[i] == h[j]) tmp[j] = j;
                }
                else {
                    if (n[i] == h[j] && j-1 >= 0 && tmp[j-1] != -1) tmp[j] = tmp[j-1];
                    else tmp[j] = -1;
                }
            }
        }

        for (int i : tmp) {
            if (i != -1) return i;
        }

        return -1;
    }

}
