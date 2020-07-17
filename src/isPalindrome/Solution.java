package isPalindrome;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/10
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        if (x<0) return false;
        char[] tmp = new char[11];
        int count = 0;
        while (x > 9) {
            tmp[count] = (char)((x % 10) + 48);
            x /= 10;
            count++;
        }
        tmp[count] = (char)(x + 48);
        String str1 = String.copyValueOf(tmp, 0, count+1);
        char[] num = new char[count+1];
        for (int i = 0; i < num.length; i++) {
            num[i] = tmp[num.length-1-i];
        }
        String str2 = String.copyValueOf(num);
        return str1.equals(str2);
    }

    public static void main(String[] args) {
        int x = 11211;
        System.out.println(isPalindrome(x));
    }
}
