package canConstruct2;

/**
 * @author: ffzs
 * @Date: 2024/1/7 上午8:50
 */
public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a'] -= 1;
            if (cnt[c - 'a'] < 0) return false;
        }

        return true;
    }

}
