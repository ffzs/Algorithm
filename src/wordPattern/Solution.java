package wordPattern;

/**
 * @author: ffzs
 * @Date: 2020/12/16 上午7:58
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) return false;
        String[] tmp = new String[26];
        for (int i = 0; i < pattern.length(); i++) {
            int idx = pattern.charAt(i)-'a';
            if (tmp[idx]==null) {
                for (String str : tmp) {
                    if (str!=null && str.equals(strs[i])) return false;
                }
                tmp[idx] = strs[i];
            }
            else {
                if (!strs[i].equals(tmp[idx])) return false;
            }
        }
        return true;
    }
}
