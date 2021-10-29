package singleNumber2;

/**
 * @author: ffzs
 * @Date: 2021/10/30 上午7:25
 */
public class Solution2 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        xor = (xor ^ (xor -1)) & xor;

        int[] res = new int[2];

        for (int num : nums) {
            if ((num & xor) == 0) res[0] ^= num;
            else res[1] ^= num;
        }

        return res;
    }

}
