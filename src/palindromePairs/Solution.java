package palindromePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/8/6 上午7:29
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; j++) {
                if (palindrome(words[i], words[j])) res.add(Arrays.asList(i,j));
                if (palindrome(words[j], words[i])) res.add(Arrays.asList(j,i));
            }
        }
        return res;
    }

    private boolean palindrome (String s1, String s2) {
        String s = s1 + s2;
        int l = 0, r = s.length() -1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l ++;
            r --;
        }
        return true;
    }
}

