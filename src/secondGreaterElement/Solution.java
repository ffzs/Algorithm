package secondGreaterElement;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2023/12/12 上午9:04
 */
public class Solution {

    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] tmp = new int[n];

        Arrays.fill(res, -1);

        Deque<Integer> stk1 = new LinkedList<>();
        Deque<Integer> stk2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int v = nums[i];
            while (!stk2.isEmpty() && nums[stk2.peekLast()] < v) {
                res[stk2.pollLast()] = v;
            }

            int idx = 0;
            while (!stk1.isEmpty() && nums[stk1.peekLast()] < v) {
                tmp[idx++] = stk1.pollLast();
            }

            for (int j = idx-1; j >= 0; j--) {
                stk2.addLast(tmp[j]);
            }

            stk1.addLast(i);
        }

        return res;
    }

}
