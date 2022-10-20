package kthGrammar;

/**
 * @author: ffzs
 * @Date: 2022/10/20 下午7:37
 */
public class Solution {

    public int kthGrammar(int n, int k) {
        k -= 1;
        int res = 0;
        while (k > 0) {
            k &= k - 1;
            res ^= 1;
        }
        return res;
    }

}
