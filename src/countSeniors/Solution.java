package countSeniors;

/**
 * @author: ffzs
 * @Date: 2023/10/23 上午8:33
 */
public class Solution {

    public int countSeniors(String[] details) {
        int res = 0;
        for (String detail : details) {
            if (detail.charAt(11) >= '6') {
                if (detail.charAt(11) == '6' && detail.charAt(12) == '0') continue;
                res += 1;
            }
        }

        return res;
    }

}
