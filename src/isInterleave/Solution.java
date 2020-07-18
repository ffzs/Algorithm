package isInterleave;

/**
 * @author: ffzs
 * @Date: 2020/7/18 上午7:45
 */
public class Solution {
    static int l1, l2, l3;
    static char[] c1, c2, c3;
    public static boolean isInterleave(String s1, String s2, String s3) {
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        c3 = s3.toCharArray();
        if (l1 + l2 != l3) return false;
        return isMatch(0,0,0);
    }

    private static boolean isMatch (int i, int j, int k) {
        boolean f1, f2;

        while (k < l3) {
            if (i < l1 && c1[i] == c3[k]) {
                if (j < l2 && c2[j] == c3[k]) {
                    f1 = isMatch(i+1, j, k+1);
                    f2 = isMatch(i, j+1, k+1);
                    return f1||f2;
                }
                else i++;
            }
            else if (j < l2 && c2[j] == c3[k]) j++;
            else return false;
            k++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
