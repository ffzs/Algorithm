package checkDistances;

/**
 * @author: ffzs
 * @Date: 2023/4/9 上午7:43
 */
public class Solution {

    public boolean checkDistances(String s, int[] distance) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '#') continue;
            int d = distance[cs[i] - 'a'] + i + 1;
            if (d >= cs.length || cs[d] != cs[i]) return false;
            cs[i] = cs[d] = '#';
        }
        return true;
    }

}
