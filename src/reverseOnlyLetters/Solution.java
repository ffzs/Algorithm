package reverseOnlyLetters;

/**
 * @author: ffzs
 * @Date: 2022/2/23 上午10:32
 */
public class Solution {
    char[] cs;
    public String reverseOnlyLetters(String s) {
        cs = s.toCharArray();
        int l = 0, r = cs.length-1;
        while (l < r) {
            while (l < r && !isLetter(l)) l++;
            while (l < r && !isLetter(r)) r--;
            swap(l++, r--);
        }
        return new String(cs);
    }

    private boolean isLetter (int i) {
        return (cs[i] >= 'a' && cs[i] <= 'z') || (cs[i] >= 'A' && cs[i] <= 'Z');
    }

    private void swap (int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }

}
