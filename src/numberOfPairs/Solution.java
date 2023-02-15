package numberOfPairs;

/**
 * @author: ffzs
 * @Date: 2023/2/16 上午6:21
 */
public class Solution {

    public int[] numberOfPairs(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num] += 1;
        }

        int pair = 0, remain = 0;

        for (int i : cnt) {
            remain += i % 2;
            pair += i / 2;
        }

        return new int[]{pair, remain};
    }

}
