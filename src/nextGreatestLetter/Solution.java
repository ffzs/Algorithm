package nextGreatestLetter;

/**
 * @author: ffzs
 * @Date: 2022/4/3 上午8:53
 */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if (target >= letters[n-1]) return letters[0];

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (letters[mid] == target) {
                while (mid + 1< n && letters[mid] == letters[mid + 1]) ++mid;
                return letters[mid + 1];
            }
            else if (letters[mid] < target) l = mid + 1;
            else r = mid;
        }
        return letters[l];
    }

}
