package reformat;

/**
 * @author: ffzs
 * @Date: 2022/8/11 上午10:53
 */
public class Solution {

    public String reformat(String s) {
        StringBuilder res = new StringBuilder();
        char[] cs = s.toCharArray();
        int n = s.length();
        int[] letters = new int[n], nums = new int[n];
        int i = 0, j = 0;
        for (char c : cs) {
            if (c >= '0' && c <= '9') nums[i++] = c;
            else letters[j++] = c;
        }

        if (Math.abs(i -j) > 1) return "";
        if (i - j > 0) return helper(nums, letters, n);
        else return helper(letters, nums, n);
    }

    private String helper(int[] l1, int[] l2, int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) sb.append((char) l1[i/2]);
            else sb.append((char) l2[i/2]);
        }
        return sb.toString();
    }

}
