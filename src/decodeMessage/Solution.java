package decodeMessage;

/**
 * @author: ffzs
 * @Date: 2023/2/1 下午3:43
 */
public class Solution {

    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        char idx = 'a';
        char[] cs = key.toCharArray();
        for (char c : cs) {
            if (c == ' ') continue;
            if (map[c - 'a'] == 0) {
                map[c - 'a'] = idx++;
                if (idx > 'z') break;
            }
        }

        char[] ms = message.toCharArray();
        for (int i = 0; i < ms.length; i++) {
            if (ms[i] == ' ') continue;
            ms[i] = map[ms[i]-'a'];
        }
        return new String(ms);
    }

}
