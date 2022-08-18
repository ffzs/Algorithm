package maxEqualFreq;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/8/18 上午11:02
 */
public class Solution {

    public int maxEqualFreq(int[] nums) {
        int[] cnt = new int[100001];
        int[] freq = new int[100001];
        for (int num : nums) {
            cnt[num]++;
            freq[cnt[num]]++;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (cnt[num] * freq[cnt[num]] == i) return i+1;
            freq[cnt[num]]--;
            cnt[num]--;
            if (cnt[nums[i-1]] * freq[cnt[nums[i-1]]] == i) return i + 1;
        }
        return 0;
    }

}
