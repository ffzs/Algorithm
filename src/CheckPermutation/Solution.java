package CheckPermutation;

/**
 * @author: ffzs
 * @Date: 2022/9/27 下午2:53
 */
public class Solution {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] cnt = new int[128];
        for (char c : s1.toCharArray()) {
            cnt[c] += 1;
        }

        for (char c : s2.toCharArray()) {
            cnt[c] -= 1;
        }

        for (int i : cnt) {
            if (i != 0) return false;
        }

        return true;
    }

}
