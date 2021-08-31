package compareVersion;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/9/1 上午6:46
 */
public class Solution {

    public int compareVersion(String version1, String version2) {

        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        int n = Math.max(s1.length, s2.length);

        for (int i = 0; i < n; i++) {
            if (i < s1.length && i < s2.length) {
                int v = compare(s1[i], s2[i]);
                if (v != 0) return v;
            }
            else if (i < s1.length) {
                if (Integer.parseInt(s1[i]) != 0) return 1;
            }
            else {
                if (Integer.parseInt(s2[i]) != 0) return -1;
            }
        }
        return 0;
    }

    private int compare(String a, String b){
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        if (x == y) {
            return 0;
        }
        return x > y ? 1:-1;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.compareVersion("0.1.1", "1.1"));
    }
}
