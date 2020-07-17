package isPalindrome;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/10
 */
public class Solution2 {
    public static boolean isPalindrome(int x) {
        if (x<0) return false;
        int[] tmp = new int[10];
        int count = 0;
        while (x > 9) {
            tmp[count] = x % 10;
            x /= 10;
            count++;
        }
        tmp[count] = x;
        for (int i = 0; i < (count+1)/2; i++) {
            System.out.println(tmp[i] + ":" +tmp[count-i]);
            if (tmp[i]!=tmp[count-i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 101;
        System.out.println(isPalindrome(x));
    }
}
