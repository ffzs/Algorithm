package numDifferentIntegers;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2022/12/6 上午10:17
 */
public class Solution {

    public int numDifferentIntegers(String word) {
        char[] cs = word.toCharArray();
        Set<String> nums = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                if (sb.length() == 0 && cs[i] == '0' && i < cs.length - 1 && cs[i + 1] >= '0' && cs[i + 1] <= '9') continue;
                sb.append(cs[i]);
            }
            else if (sb.length() > 0) {
                nums.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        if (sb.length() > 0) nums.add(sb.toString());
        return nums.size();
    }

}
