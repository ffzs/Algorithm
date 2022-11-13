package customSortString;

/**
 * @author: ffzs
 * @Date: 2022/11/13 下午2:29
 */
public class Solution {

    public String customSortString(String order, String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            int num = cnt[c - 'a'];
            if (num == 0) continue;
            for (int i = 0; i < num; i++) {
                sb.append(c);
            }
            cnt[c - 'a'] = 0;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                char it = (char)('a' + i);
                for (int j = 0; j < cnt[i]; j++) {
                    sb.append(it);
                }
            }
        }
        return sb.toString();
    }

}
