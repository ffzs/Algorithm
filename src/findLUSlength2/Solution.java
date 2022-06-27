package findLUSlength2;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/6/27 下午2:35
 */
public class Solution {

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        int n = strs.length;
        boolean flag;
        for (int i = 0; i < n; i++) {
            String it = strs[i];
            flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                String str = strs[j];
                if (str.length() < it.length()) break;
                if (str.equals(it) || str.contains(it) || (str.length() > it.length() && isSubStr(str, it))) {
                    flag = false;
                    break;
                }
            }
            if (flag) return it.length();
        }
        return -1;
    }

    private boolean isSubStr (String str, String it) {
        int i = 0;
        for (char c : it.toCharArray()) {
            while (i < str.length() && str.charAt(i) != c) {
                i += 1;
            }
            if (i >= str.length()) return false;
            i += 1;
        }
        return true;
    }
}


class Test {
    public static void main(String[] args) {
        String[] strs = {"abcabc","abcabc","abcabc","abc","abc","cca"};
        Solution s = new Solution();
        System.out.println(s.findLUSlength(strs));
    }
}