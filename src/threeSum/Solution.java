package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ffzs
 * @describe
 * 一正两负， 一负两正
 * @date 2020/6/12
 */

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int max=0, min=0;
        int zero = 0, plus = 0, minus = 0;
        for (int num : nums) {
            if (num==0) zero++;
            else if (num>0){
                max = Math.max(max, num);
                plus ++;
            }
            else {
                min = Math.min(min, num);
                minus ++;
            }
        }

        if (zero>=3) {
            res.add(new ArrayList<>(List.of(0,0,0)));
        }

        if (nums.length < 3 || max==0 || min == 0) {
            return res;
        }

        if (min*2 + max > 0) max = -2*min;
        else if (max*2 + min < 0) min = -2*max;

        int[] map = new int[max-min+1];
        int[] ps = new int[plus];
        int[] ms = new int[minus];

        plus = 0;
        minus = 0;
        for (int num : nums) {
            if (num>=min && num<=max) {
                if (map[num-min]++ == 0){
                    if (num > 0) ps[plus++] = num;
                    else if (num < 0) ms[minus++] = num;
                }
            }
        }

        Arrays.sort(ps,0,plus);
        Arrays.sort(ms,0,minus);

        int start=0;
        for (int i = minus-1; i >= 0; --i) {
            int m = ms[i];
            int minP = -m/2;  // 确定边界，左边选一个右边选一个 m <= sum <= p
            while (start < plus && ps[start] < minP) start++;
            for (int j = start; j < plus; j++) {
                int p = ps[j];
                int sum = -(p+m);
                if (sum >= m && sum <= p) {  // 控制边界 避免重复
                    if (sum == m || sum == p) {
                        if (map[sum - min] > 1) res.add(Arrays.asList(m, sum, p));
                    } else if (map[sum - min] > 0) res.add(Arrays.asList(m, sum, p));
                }
                else if (sum < m) break; // 控制边界 避免重复
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-1,-4};
//        int[] nums = {0,0,0};
        System.out.println(threeSum(nums));
    }
}
