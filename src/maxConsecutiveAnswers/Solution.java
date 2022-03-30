package maxConsecutiveAnswers;

/**
 * @author: ffzs
 * @Date: 2022/3/29 上午8:53
 */
public class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] cs = answerKey.toCharArray();
        int l = 0, r = 0, res = 0, T = 0, F = 0, n = cs.length;
        while (r < n) {
            if (cs[r] == 'T') ++ T;
            else ++ F;
            while (T > k && F > k) {
                if (cs[l++] == 'T') --T;
                else --F;
            }
            res = Math.max(res, r - l + 1);
            ++r;
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxConsecutiveAnswers("FFFTTFTTFT", 3));
    }
}