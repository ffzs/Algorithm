package toLowerCase;

/**
 * @author: ffzs
 * @Date: 2021/12/12 上午8:10
 */
public class Solution {
    static int diff = 'a' - 'A';
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c = (char)(c + diff);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
