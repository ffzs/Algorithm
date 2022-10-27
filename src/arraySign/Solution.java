package arraySign;

/**
 * @author: ffzs
 * @Date: 2022/10/27 下午2:01
 */
public class Solution {

    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            else if (num < 0) res *= -1;
        }
        return res;
    }

}
