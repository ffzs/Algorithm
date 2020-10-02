package numJewelsInStones;

/**
 * @author: ffzs
 * @Date: 2020/10/2 上午7:46
 */


public class Solution {

    public int numJewelsInStones(String J, String S) {
        boolean[] js = new boolean[('z' - 'A') + 1];
        int counter = 0;
        for (int i = 0; i < J.length(); i++) {
            js[J.charAt(i)-'A'] = true;
        }

        for (int i = 0; i < S.length(); i++) {
            if (js[S.charAt(i)-'A']) counter++;
        }
        return counter;
    }

}
