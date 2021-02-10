package checkInclusion;

/**
 * @author: ffzs
 * @Date: 2021/2/10 上午9:31
 */
public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        if (c1.length > c2.length) return false;

        int[] counter = new int[26];

        for (char c : c1) counter[c - 'a']++;

        int left = 0, right = 0;

        while (right < c2.length) {
            int cur = c2[right] - 'a';
            counter[cur]--;
            while (counter[cur] < 0 ) {
                counter[c2[left++] - 'a']++;
            }
            if (right - left + 1 == c1.length) return true;
            right++;
        }
        return false;
    }

}
