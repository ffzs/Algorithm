package countRangeSum;

/**
 * @author: ffzs
 * @Date: 2020/11/7 上午10:12
 */
public class Solution2 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for(int j = i; j>=0; j--) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) res ++;
            }
        }
        return res;
    }

}
