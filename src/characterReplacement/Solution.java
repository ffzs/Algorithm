package characterReplacement;

/**
 * @author: ffzs
 * @Date: 2021/2/2 上午9:55
 */
public class Solution {

    public int characterReplacement(String s, int k) {
        int[] counter = new int[26];
        char[] c = s.toCharArray();
        int n = c.length;
        int max = 0;
        int left = 0, right = 0;

        while (right < n) {
            counter[c[right] - 'A'] ++;
            max = Math.max(max, counter[c[right] - 'A']);
            if (right - left + 1 - max > k) {
                counter[c[left] - 'A'] --;
                left ++;
            }
            right ++;
        }
        return right - left;
    }

}
