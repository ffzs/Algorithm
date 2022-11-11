package halvesAreAlike;

/**
 * @author: ffzs
 * @Date: 2022/11/11 下午2:24
 */
public class Solution {
    static boolean[] isVowels = new boolean[128];
    static {
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        for (char vowel : vowels) {
            isVowels[vowel] = true;
        }
    }
    public boolean halvesAreAlike(String s) {
        int n = s.length(), cnt = 0;
        for (int i = 0; i < n/2; i++) {
            if (isVowels[s.charAt(i)]) cnt += 1;
        }

        for (int i = n / 2; i < n; i++) {
            if (isVowels[s.charAt(i)]) cnt -= 1;
        }
        return cnt == 0;
    }

}
