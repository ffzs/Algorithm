package predictPartyVictory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2020/12/11 上午8:50
 */
public class Solution2 {
    public String predictPartyVictory(String senate) {
        char[] cs = senate.toCharArray();
        Queue<Integer> R = new LinkedList<>();
        Queue<Integer> D = new LinkedList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'R') R.offer(i);
            else D.offer(i);
        }

        while (!R.isEmpty() && !D.isEmpty()) {
            int r = R.poll(), d = D.poll();
            if (r < d) R.offer(cs.length + r);
            else D.offer(cs.length + d);
        }

        return D.isEmpty()? "Radiant" : "Dire";
    }
}
