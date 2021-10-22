package majorityElement2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/10/22 上午7:18
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int p1 = 0, p2 = 0 ,v1 = 0, v2 = 0;
        for (int num : nums) {
            if (p1 == num) v1 ++;
            else if (p2 == num) v2 ++;
            else if (v1 == 0) {
                p1 = num;
                v1 = 1;
            }
            else if (v2 == 0) {
                p2 = num;
                v2 = 1;
            }
            else {
                v1--;
                v2--;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == p1) cnt1++;
            else if (num == p2) cnt2++;
        }
        if (cnt1 > n/3) res.add(p1);
        if (cnt2 > n/3) res.add(p2);
        return res;
    }
}
