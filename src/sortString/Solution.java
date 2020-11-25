package sortString;

/**
 * @author: ffzs
 * @Date: 2020/11/25 上午7:34
 */
public class Solution {
    StringBuilder sb = new StringBuilder();
    public String sortString(String s) {
        char[] chars = s.toCharArray();
        int[] counter = new int[26];
        for (char c : chars) {
            counter[c-'a']++;
        }
        add(counter, chars.length, 0);
        return sb.toString();
    }

    private void add (int[] counter, int len, int dir) {
        if (dir == 0) {
            for (int i = 0; i < counter.length; i++) {
                if (counter[i] != 0) {
                    sb.append((char)(i+'a'));
                    counter[i]--;
                    len--;
                }
            }
            if (len > 0) add(counter, len, 1);
        }
        else {
            for (int i = counter.length - 1; i >= 0; i--) {
                if (counter[i] != 0) {
                    sb.append((char)(i+'a'));
                    counter[i]--;
                    len--;
                }
            }
            if (len > 0) add(counter, len, 0);
        }
    }
}
