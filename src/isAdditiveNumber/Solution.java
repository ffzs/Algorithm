package isAdditiveNumber;

/**
 * @author: ffzs
 * @Date: 2022/1/10 上午6:43
 */
public class Solution {
    int n;
    String num;
    public boolean isAdditiveNumber(String num) {
        this.num = num;
        n = num.length();

        for (int i = 0; i < (n >> 1); i++) {
            if (num.charAt(0) == '0' && i > 0) return false;
            for (int j = i+1; j < i+1+(n-i-1)/2; j++) {
                if (num.charAt(i+1) == '0' && j > i+1) continue;
                long a = Long.parseLong(num.substring(0, i+1));
                long b = Long.parseLong(num.substring(i+1, j+1));
                if (isValid(a, b, j + 1)) return true;
            }
        }
        return false;
    }

    private boolean isValid (long a, long b, int idx) {
        if (idx == n) return true;

        for (int i = idx; i < n; i++) {
            if (num.charAt(idx) == '0' && i > idx) return false;
            long cur = Long.parseLong(num.substring(idx, i+1));
            if (cur > a+b) return false;
            if (cur == a + b) {
                if (isValid(b, cur, i + 1)) return true;
            }
        }
        return false;
    }

}
