package canTransform;

/**
 * @author: ffzs
 * @Date: 2022/10/2 下午1:58
 */
public class Solution {

    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        char[] op = start.toCharArray(), ed = end.toCharArray();
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && op[i] == 'X') i += 1;
            while (j < n && ed[j] == 'X') j += 1;
            if (i == n || j == n) break;
            if (op[i] != ed[j]) return false;
            if (op[i] == 'L' && i < j) return false;
            if (op[i] == 'R' && i > j) return false;
            i += 1;
            j += 1;
        }
        while (i < n) if (op[i++] != 'X') return false;
        while (j < n) if (ed[j++] != 'X') return false;
        return true;
    }

}
