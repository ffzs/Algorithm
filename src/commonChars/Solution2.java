package commonChars;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/10/14 上午7:59
 */
public class Solution2 {

    public List<String> commonChars(String[] A) {
        int[] counter = new int['z'-'a' +1];
        for (int i = 0; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            if (i == 0) {
                for (char c : chars) counter[c-'a']++;
            }else {
                int[] tmp = new int['z'-'a' +1];
                for (char c : chars) tmp[c-'a']++;
                for (int j = 0; j < counter.length; j++) {
                    if (counter[j] !=0) counter[j] = Math.min(counter[j], tmp[j]);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0){
                for (int i1 = 0; i1 < counter[i]; i1++) {
                    res.add(String.valueOf((char)(i+'a')));
                }
            }
        }
        return res;
    }
}
