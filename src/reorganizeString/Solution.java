package reorganizeString;

/**
 * @author: ffzs
 * @Date: 2020/11/30 上午7:15
 */

public class Solution {
    public String reorganizeString(String S) {
        char[] cs = S.toCharArray();
        int[] counter = new int[26];

        for (char c : cs) {
            counter[c-'a']++;
            if (counter[c-'a']>(cs.length+1)/2) return "";
        }

        int pre = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            int max = 0, idx=0;
            for (int j = 0; j < counter.length; j++) {
                if (counter[j] > max && j != pre) {
                    max = counter[j];
                    idx = j;
                }
            }
            sb.append((char)(idx + 'a'));
            counter[idx]--;
            pre = idx;
        }
        return sb.toString();
    }
}
