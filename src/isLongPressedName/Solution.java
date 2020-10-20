package isLongPressedName;

/**
 * @author: ffzs
 * @Date: 2020/10/21 上午7:05
 */
public class Solution {

    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length() || name.charAt(0) != typed.charAt(0)) return false;
        int i = 1, j = 1;
        while (i<name.length() && j<typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;j++;
            }
            else if (name.charAt(i-1) == typed.charAt(j)) {
                j++;
            }
            else return false;
        }
        if (i != name.length()) return false;
        for (int k=j; k<typed.length(); k++) {
            if (name.charAt(i-1) != typed.charAt(k)) return false;
        }
        return true;
    }
}
