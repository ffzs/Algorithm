package findComplement;

/**
 * @author: ffzs
 * @Date: 2021/10/18 下午5:29
 */
public class Solution {

    public int findComplement(int num) {
        int idx = 1, tmp = num;
        while ((tmp >>> 1) != 0) {
            tmp = tmp >>> 1;
            idx++;
        }
        return num ^ ((1 << idx) - 1);
    }
}
