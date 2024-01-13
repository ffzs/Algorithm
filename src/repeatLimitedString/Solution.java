package repeatLimitedString;

/**
 * @author: ffzs
 * @Date: 2024/1/13 下午2:11
 * bbbcbbbabbb repeatLimit 3
 */
public class Solution {

    public static String repeatLimitedString(String s, int repeatLimit) {
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : cs) {
            cnt[c - 'a'] += 1;
        }

        int j;
        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            j = i - 1;
            while (cnt[i] > 0) {
                for (int k = 0; k < Math.min(cnt[i], repeatLimit); k++) {
                    sb.append((char)(i + 'a'));
                }

                cnt[i] -= repeatLimit;

                if (cnt[i] >= 0) {
                    while (j >= 0 && cnt[j] == 0) j-=1;

                    if (j >= 0) {
                        sb.append((char) (j + 'a'));
                        cnt[j] -= 1;
                    }
                    else break;
                }
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(Solution.repeatLimitedString("bbbcbbbabbb", 3));
    }

}
