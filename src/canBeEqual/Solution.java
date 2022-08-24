package canBeEqual;

/**
 * @author: ffzs
 * @Date: 2022/8/24 上午11:51
 */
public class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cnt = new int[1001];
        for (int i = 0; i < target.length; i++) {
            cnt[target[i]] += 1;
            cnt[arr[i]] -= 1;
        }

        for (int i : cnt) {
            if (i != 0) return false;
        }

        return true;
    }

}
