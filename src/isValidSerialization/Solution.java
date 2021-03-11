package isValidSerialization;

/**
 * @author: ffzs
 * @Date: 2021/3/12 上午7:12
 */
public class Solution {

    public boolean isValidSerialization(String preorder) {
        char[] cs = preorder.toCharArray();
        int n = cs.length;
        int i = 0;
        int pos = 1;

        while (i < n) {
            if (pos == 0) return false;
            switch (cs[i]) {
                case ',':
                    i++;
                    break;
                case '#':
                    pos--;
                    i++;
                    break;
                default:
                    while (i<n && cs[i] != ',') i++;
                    pos++;
            }
        }

        return pos == 0;
    }

}
