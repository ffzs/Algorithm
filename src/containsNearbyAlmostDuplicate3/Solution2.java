package containsNearbyAlmostDuplicate3;

import java.util.TreeSet;

/**
 * @author: ffzs
 * @Date: 2021/4/17 上午8:40
 */
public class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        int n = nums.length;
        if (n == 0 || k == 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        set.add((long)nums[0]);
        for (int i = 1; i < n; i++) {
            Long upper = set.ceiling((long)nums[i]-t);
            if (upper != null && upper <= (long)nums[i] + t) return true;
            set.add((long)nums[i]);
            if (i >= k) set.remove((long)nums[i-k]);
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {4,1,6,3};
        Solution2 s = new Solution2();
        System.out.println(s.containsNearbyAlmostDuplicate(nums, 100, 1));
    }
}
