package longestCommonPrefix;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/15
 */
public class Solution2 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String first = strs[0];
        for (String str : strs) {
            while (str.indexOf(first) != 0) {
                first = first.substring(0, first.length() - 1);
                if (first.isEmpty()) return "";
            }
        }

        return first;
    }
}
