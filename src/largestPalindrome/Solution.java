package largestPalindrome;

/**
 * @author: ffzs
 * @Date: 2022/4/16 上午8:33
 */
public class Solution {
    static int[] tmp = new int[8];
    static {
        tmp[0] = 9;
        tmp[1] = 987;
    }
    public static int largestPalindrome(int n) {
        if (tmp[n-1] != 0) return tmp[n-1];
        int it = (int)Math.pow(10, n) - 1;
        int res = 0;
        for (int left = it; res == 0; --left) {
            long v = left;
            for (int j = left; j > 0; j /= 10) {
                v = v * 10 + j % 10;
            }
            for (long j = it; j * j >= v; j--) {
                if (v % j == 0) {
                    res = (int)(v % 1337);
                    break;
                }
            }
        }
        return tmp[n-1] = res;
    }

}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 1; i < 9; i++) {
            System.out.println(s.largestPalindrome(i));
        }
    }
}
