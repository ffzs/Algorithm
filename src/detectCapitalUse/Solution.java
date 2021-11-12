package detectCapitalUse;

/**
 * @author: ffzs
 * @Date: 2021/11/13 上午7:21
 */
public class Solution {

    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) return true;
        int[] cnt = new int[2];
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (isLower(cur)) cnt[0] ++;
            else cnt[1] ++;
        }
        return cnt[1] == 0 || cnt[0] == 0 || (cnt[1] == 1 && !isLower(word.charAt(0)));
    }

    private boolean isLower(char cur) {
        return cur >= 'a' && cur <= 'z';
    }

}
