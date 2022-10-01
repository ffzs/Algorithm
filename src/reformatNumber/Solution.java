package reformatNumber;

/**
 * @author: ffzs
 * @Date: 2022/10/1 下午1:57
 */
public class Solution {

    public String reformatNumber(String number) {
        char[] cs = number.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (char c : cs) {
            if (c == ' ' || c == '-') continue;
            else {
                if (cnt == 3) {
                    sb.append('-');
                    cnt = 0;
                }
                sb.append(c);
                cnt += 1;
            }
        }
        if (sb.charAt(sb.length()-2) == '-') {
            sb.deleteCharAt(sb.length() - 2);
            sb.insert(sb.length()-1, '-');
        }
        return sb.toString();
    }

}
