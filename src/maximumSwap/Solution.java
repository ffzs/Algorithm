package maximumSwap;

/**
 * @author: ffzs
 * @Date: 2022/9/13 上午11:31
 */
public class Solution {

    public int maximumSwap(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int n = cs.length;
        for (int i = 1; i < n; i++) {
            if (cs[i] > cs[i-1]) {
                char suf = cs[i];
                int idx = i;
                for (int j = i + 1; j < n; j++) {
                    if (cs[j] >= suf) {
                        idx = j;
                        suf = cs[j];
                    }
                }
                for (int j = 0; j < i; j++) {
                    if (suf > cs[j]) {
                        cs[idx] = cs[j];
                        cs[j] = suf;
                        return Integer.parseInt(new String(cs));
                    }
                }
            }
        }
        return num;
    }
}
