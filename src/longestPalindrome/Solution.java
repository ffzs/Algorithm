package longestPalindrome;

/**
 * @author ffzs
 * @describe 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */
public class Solution {
    static int[] res;
    static char[] seq;
    public static String longestPalindrome(String s) {
        seq = s.toCharArray();
        int len = seq.length;
        if (len <= 1) return s;
        res = new int[3];
        int left = 0;
        while (left < len-1) {
            left = expandAroundCenter(left);
        }
        return s.substring(res[1], res[2]);
    }

    private static int expandAroundCenter(int left) {
        int right = left+1;
        // 解决偶数回文以及相同字符问题
        while (right<seq.length && seq[right]==seq[left]){
            right ++;
        }
        int tmp = right;
        // 奇数情况以left为中心
        while (left>0 && right<seq.length && seq[left-1]==seq[right]) {
            left--;
            right++;
        }
        if (right-left>res[0]) {
            res[0] = right-left;
            res[1] = left;
            res[2] = right;
        }
        return tmp;
    }

    public static void main(String[] args) {
        String s= "bbb";
        System.out.println(longestPalindrome(s));
    }
}
