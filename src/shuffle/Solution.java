package shuffle;

/**
 * @author: ffzs
 * @Date: 2022/8/29 下午12:32
 */
public class Solution {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = 0, j = 0; i < n; i++) {
            res[j++] = nums[i];
            res[j++] = nums[i + n];
        }
        return res;
    }
}
