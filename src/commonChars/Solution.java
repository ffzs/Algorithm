package commonChars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/10/14 上午7:34
 */
public class Solution {

    public List<String> commonChars(String[] A) {
        int[][] tmp = new int['z'-'a'+1][A.length];
        for (int i = 0; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            for (char c : chars) {
                tmp[c-'a'][i]++;
            }
        }

        List<String> res = new ArrayList<>();
        int min;
        for (int i = 0; i < tmp.length; i++) {
            min = A.length;
            for (int l : tmp[i]) {
                min = Math.min(l, min);
            }
            if (min > 0) {
                char letter = (char) ('a' + i);
                for (int j = 0; j < min; j++) {
                    res.add(""+letter);
                }
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] A = {"bella","label","roller"};
        System.out.println(solution.commonChars(A));
    }
}
