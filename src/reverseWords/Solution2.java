package reverseWords;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/8/30 上午7:38
 */
public class Solution2 {
    char[] seq;
    int pre = 0;
    public String reverseWords(String s) {
        this.seq = s.toCharArray();
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == ' ') {
                reverse(pre, i-1);
                pre = i+1;
            }
        }
        reverse(pre, seq.length-1);
        return new String(seq);
    }
    private void reverse (int l, int r) {
        while (l<r){
            char tmp = seq[l];
            seq[l++] = seq[r];
            seq[r--] = tmp;
        }
    }
}
