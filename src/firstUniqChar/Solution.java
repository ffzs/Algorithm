package firstUniqChar;

/**
 * @author: ffzs
 * @Date: 2020/12/23 上午8:25
 */
public class Solution {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] counter = new int[26];

        for (char c : chars) {
            counter[c-'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (counter[chars[i]-'a'] == 1) return i;
        }

        return -1;
    }

}
