package canConstruct;

/**
 * @author: ffzs
 * @Date: 2021/12/4 上午7:57
 */
public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        int n = ransomNote.length();

        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a'] ++;
        }

        for (char c : magazine.toCharArray()) {
            int i = c - 'a';
            if (cnt[i] > 0) {
                cnt[i] --;
                n --;
            }
            if (n == 0) return true;
        }

        return false;
    }

}
