package medianSlidingWindow;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/2/3 下午6:07
 */
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int left = 0, right = k-1;
        boolean isEven = (k&1) == 0;
        while (right < nums.length) {
            int[] tmp = Arrays.copyOfRange(nums, left, right+1);
            Arrays.sort(tmp);
            int mid = (right - left) >>> 1;
            if (isEven) {
                res[left] = ((long)tmp[mid] + tmp[mid+1])/2D;
            }else{
                res[left] = tmp[mid];
            }
            left++;
            right++;
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.medianSlidingWindow(nums, 3)));
    }
}
