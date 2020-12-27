package isIsomorphic;

/**
 * @author: ffzs
 * @Date: 2020/12/27 上午10:10
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[128];
        int[] remap = new int[128];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        for (int i = 0; i < sc.length; i++) {
            int c1 = sc[i];
            int c2 = tc[i];
            if (map[c1] == 0 && remap[c2] == 0) {
                map[c1] = c2;
                remap[c2] = c1;
            }
            else {
                if (map[c1] != c2 | remap[c2] != c1) return false;
            }
        }

        return true;
    }
}
