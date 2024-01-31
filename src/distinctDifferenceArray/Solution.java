package distinctDifferenceArray;

/**
 * @author: ffzs
 * @Date: 2024/1/31 下午7:44
 */
public class Solution {

    public int[] distinctDifferenceArray(int[] nums) {
        int[] cnt = new int[51];
        int suf = 0;
        int pre = 0;
        for (int num : nums) {
            cnt[num] += 1;
            if (cnt[num] == 1) suf += 1;
        }

        int[] res = new int[nums.length];
        int[] tnc = new int[51];
        for (int i = 0; i < nums.length; i++) {
            tnc[nums[i]] += 1;
            if (tnc[nums[i]] == 1) pre += 1;
            cnt[nums[i]] -= 1;
            if (cnt[nums[i]] == 0) suf -= 1;
            res[i] = pre - suf;
        }
        return res;
    }

}
