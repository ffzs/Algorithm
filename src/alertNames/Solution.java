package alertNames;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/2/7 下午1:28
 */
public class Solution {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            int now = getTime(keyTime[i]);
            if (!map.containsKey(name)) map.put(name, new ArrayList<>());
            map.get(name).add(now);
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();
            if (times.size() <= 2) continue;
            times.sort(Comparator.naturalOrder());
            int pro = times.get(0), gap = 61;
            for (int i = 1; i < times.size(); i++) {
                int cur = times.get(i) - pro;
                if (cur + gap <= 60) {
                    res.add(name);
                    break;
                }
                pro = times.get(i);
                gap = cur;
            }
        }
        res.sort(Comparator.naturalOrder());
        return res;
    }

    private int getTime(String s) {
        return ((s.charAt(0) - '0') * 10 + s.charAt(1) - '0') * 60 + (s.charAt(3) - '0') * 10 + s.charAt(4) - '0';
    }

}
