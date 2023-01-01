package repeatedCharacter;

/**
 * @author: ffzs
 * @Date: 2023/1/1 上午9:32
 */
public class Solution {

    public char repeatedCharacter(String s) {
        boolean[] appears = new boolean[26];
        for (char c : s.toCharArray()) {
            if (!appears[c-'a']) appears[c-'a'] = true;
            else return c;
        }
        return 'a';
    }

}
