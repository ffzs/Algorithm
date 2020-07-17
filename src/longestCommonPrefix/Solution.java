package longestCommonPrefix;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/15
 */
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder res = new StringBuilder();

        String first = strs[0];

        mark: for (int i = 0; i < first.length(); i++) {
            char it = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != it) break mark;
            }
            res.append(it);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"aa", "a"};
        String str = "abcdefg";
        System.out.println(str.indexOf("abe"));
        System.out.println(longestCommonPrefix(strs));
    }
}
