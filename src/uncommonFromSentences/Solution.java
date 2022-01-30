package uncommonFromSentences;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/1/30 上午8:02
 */
public class Solution {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, int[]> map = new HashMap<>();
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");

        for (String s : ss1) {
            if (!map.containsKey(s)) map.put(s, new int[]{0,0});
            map.get(s)[0]++;
        }
        for (String s : ss2) {
            if (!map.containsKey(s)) map.put(s, new int[]{0,0});
            map.get(s)[1]++;
        }

        int cnt = 0;
        String[] tmp = new String[map.size()];
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            int[] v = entry.getValue();
            if ((v[0] == 1 && v[1] == 0)||(v[0] == 0 && v[1] == 1)) tmp[cnt++] = entry.getKey();
        }
        String[] res = new String[cnt];
        System.arraycopy(tmp, 0, res, 0, res.length);
        return res;
    }

}
