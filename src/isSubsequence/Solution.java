package isSubsequence;

/**
 * @author: ffzs
 * @Date: 2020/7/27 上午8:03
 */

public class Solution {
    public static boolean isSubsequence(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int i = 0, j = 0;
        while (i < sc.length && j < tc.length) {
            if (sc[i] == tc[j]) i++;
            j++;
        }
        return i == sc.length;
    }

    public static void main(String[] args) {
        String s = "aaaaaa", t = "bbaaaa";
        System.out.println(isSubsequence(s, t));
    }
}
