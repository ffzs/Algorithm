package checkPalindromeFormation;

/**
 * @author: ffzs
 * @Date: 2023/3/18 上午8:40
 */
public class Solution {

    public boolean checkPalindromeFormation(String a, String b) {
        char[] ca = a.toCharArray(), cb = b.toCharArray();
        return isPalindrome(ca, 0, ca.length-1) || isPalindrome(cb, 0, cb.length - 1) || check(ca, cb) || check(cb, ca);
    }

    private boolean isPalindrome (char[] a, int l, int r) {
        while (l < r) {
            if (a[l] != a[r]) return false;
            l += 1;
            r -= 1;
        }
        return true;
    }

    private boolean check(char[] a, char[] b) {
        int l = 0, r = a.length - 1;
        while (l < r && a[l] == b[r]) {
            l += 1;
            r -= 1;
        }
        return isPalindrome(a, l, r) || isPalindrome(b, l, r);
    }

}
