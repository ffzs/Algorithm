package reverseString;

/**
 * @author: ffzs
 * @Date: 2020/10/8 上午9:39
 */
public class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while (left < right) {
            if (s[left] != s[right]) {
                swap(s, left, right);
            }
            left++; right--;
        }
    }

    private void swap (char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
