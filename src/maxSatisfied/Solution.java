package maxSatisfied;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/2/23 上午9:39
 */
public class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int res = 0;
        int left = 0, right = 0;

        while (right < n) {
            int[] vals = sum(customers, grumpy, X, left);
            System.out.println(Arrays.toString(vals));
            right = vals[0];
            res = Math.max(res, vals[1]);

            if (right >= n) break;

            while (left < n && grumpy[left] == 0) left++;
            left ++;
        }
        return res;
    }

    private int[] sum (int[] customers, int[] grumpy, int X, int i) {
        int ret = 0;
        boolean useMask = false;
        while (i < customers.length) {
            if (grumpy[i] == 0) continue;
            else if (!useMask) {
                for (int j = 0; j < X; j++) {
                    ret += customers[i++];
                }
                useMask = true;
            }
            else break;
        }
        return new int[] {i, ret};
    }
}

class Test {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        Solution2 solution = new Solution2();
        System.out.println(solution.maxSatisfied(customers, grumpy, 3));
    }
}
