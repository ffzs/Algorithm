package containsNearbyAlmostDuplicate3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: ffzs
 * @Date: 2021/4/17 上午8:15
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Long, Long> map = new HashMap<>();
        long w = t +1L;
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i], w);
            if (map.containsKey(id)) return true;
            if (map.containsKey(id-1) && Math.abs(map.get(id-1)-nums[i])<=t) return true;
            if (map.containsKey(id+1) && Math.abs(map.get(id+1)-nums[i])<=t) return true;
            map.put(id, (long)nums[i]);
            if (i >= k) map.remove(getId(nums[i-k], w));
        }
        return false;
    }

    private long getId(int num, long w) {
        return num>=0?num/w:(num+1)/w-1;
    }
}


