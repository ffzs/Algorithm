package numFriendRequests;

/**
 * @author: ffzs
 * @Date: 2021/12/27 上午7:53
 *
 * 0.5 * x + 7 > y >= x
 * ! (y > 100) & (x < 100)
 */
public class Solution {

    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] cnt = new int[121], sum = new int[121];
        for (int age : ages) {
            cnt[age]++;
        }

        for (int i = 1; i < cnt.length; i++) {
            sum[i] = sum[i-1] + cnt[i];
        }

        for (int i = 15; i < 121; i++) {
            if (cnt[i] != 0) {
                int left = i/2 + 8;
                res += cnt[i] * (sum[i] - sum[left - 1] - 1);
            }
        }
        return res;
    }

}
