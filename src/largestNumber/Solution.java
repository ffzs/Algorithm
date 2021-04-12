package largestNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: ffzs
 * @Date: 2021/4/12 上午8:32
 */
public class Solution {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] nms = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nms[i] = nums[i];
        }
        Arrays.sort(nms, this::helper);

        if (nms[0] == 0) return "0";

        StringBuilder sb = new StringBuilder();
        for (Integer nm : nms) {
            sb.append(nm);
        }

        return sb.toString();
    }

    private int helper(int num1, int num2) {
        int[] tmp1 = new int[20];
        int[] tmp2 = new int[20];
        int n = toArray(tmp1, num2, toArray(tmp1, num1, 0));
        toArray(tmp2, num1, toArray(tmp2, num2, 0));

        for (int i = n - 1; i >= 0; i--) {
            if(tmp1[i] != tmp2[i]) return tmp1[i] - tmp2[i];
        }

        return 1;
    }

    private int toArray (int[] value, int num, int i) {
        if (num == 0) {
            value[i] = 0;
            return i+1;
        }

        while (num >= 1) {
            value[i++] = num%10;
            num /= 10;
        }
        return i;
    }

}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {34323,3432};
        System.out.println(s.largestNumber(nums));
    }
}
