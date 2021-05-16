package findMaximumXOR;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/5/16 上午9:02
 */
public class Solution2 {

    public int findMaximumXOR(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int n = 32;
        while (n > 0 && maxValue >> n != 1) n--;
        n++;
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res <<= 1;
            int cur = res | 1;
            set.clear();
            for (int num : nums) {
                set.add(num>>i);
                if (set.contains(num>>i ^ cur)){
                    res |= 1;
                    break;
                }
            }
        }

        return res;
    }

}


class Test {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
//        int[] nums = {3, 10, 5, 25, 2, 8};
        int[] nums = {0};
        System.out.println(s.findMaximumXOR(nums));
    }
}