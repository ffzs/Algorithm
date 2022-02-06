package sumOfUnique;

/**
 * @author: ffzs
 * @Date: 2022/2/6 上午9:28
 */
public class Solution {

    public int sumOfUnique(int[] nums) {
        int res = 0;
        int[] cnt = new int[101];

        for (int num : nums) {
            cnt[num] ++;
        }

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1) res+=i;
        }
        return res;
    }

}
