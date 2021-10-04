package licenseKeyFormatting;

/**
 * @author: ffzs
 * @Date: 2021/10/4 上午7:32
 */
public class Solution {

    public String licenseKeyFormatting(String s, int k) {
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = cs.length-1; i >= 0; i--) {

            char c = cs[i];
            if (c == '-') continue;
            if (cnt == k) {
                sb.append("-");
                cnt = 0;
            }
            if (c >= 'a' && c <= 'z') c = (char)(c- 32);
            sb.append(c);
            cnt ++;
        }
        return sb.reverse().toString();
    }
}
