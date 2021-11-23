package originalDigits;

/**
 * @author: ffzs
 * @Date: 2021/11/24 上午7:25
 */
public class Solution {
    public String originalDigits(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        
        int[] cnt = new int[10];
        cnt[0] = map['z' - 'a'];
        cnt[2] = map['w' - 'a'];
        cnt[4] = map['u' - 'a'];
        cnt[6] = map['x' - 'a'];
        cnt[8] = map['g' - 'a'];
        
        cnt[3] = map['h' - 'a'] - cnt[8];
        cnt[5] = map['f' - 'a'] - cnt[4];
        cnt[7] = map['s' - 'a'] - cnt[6];
        
        cnt[1] = map['o' - 'a'] - cnt[0] - cnt[2] - cnt[4];
        cnt[9] = map['i' - 'a'] - cnt[5] - cnt[6] - cnt[8];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt.length; i++) {
            sb.append(String.valueOf((char) (i + '0')).repeat(Math.max(0, cnt[i])));
        }
        return sb.toString();
    }

}
