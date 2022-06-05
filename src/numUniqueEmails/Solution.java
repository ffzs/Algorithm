package numUniqueEmails;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2022/6/4 上午8:45
 */
public class Solution {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(transMailer(email));
        }
        return set.size();
    }

    private String transMailer (String email) {
        StringBuilder ret = new StringBuilder();
        char[] cs = email.toCharArray();
        int i = 0;
        boolean at = false;
        while (i < cs.length) {
            if (cs[i] == '@') at = true;
            if (!at) {
                if (cs[i] == '.') {
                    i += 1;
                    continue;
                }
                else if (cs[i] == '+') {
                    while (cs[i] != '@') i+=1;
                    at = true;
                }
            }
            ret.append(cs[i]);
            i += 1;
        }
        return ret.toString();
    }
}
