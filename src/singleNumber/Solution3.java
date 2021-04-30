package singleNumber;

/**
 * @author: ffzs
 * @Date: 2021/4/30 下午1:04
 */
public class Solution3 {

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            a = ~b & (a ^ num);
            b = ~a & (b ^ num);
        }

        return a;
    }

}
