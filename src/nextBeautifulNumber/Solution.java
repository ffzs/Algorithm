package nextBeautifulNumber;

/**
 * @author: ffzs
 * @Date: 2023/12/9 上午2:54
 */
public class Solution {

    public int nextBeautifulNumber(int n) {
        int res = n + 1;
        while (!helper(res)) res += 1;
        return res;
    }

    private boolean helper (int n) {
        int[] cnt = new int[10];

        while (n > 0) {
            cnt[n % 10] += 1;
            n /= 10;
        }

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0 && cnt[i] != i) return false;
        }
        return true;
    }

}
