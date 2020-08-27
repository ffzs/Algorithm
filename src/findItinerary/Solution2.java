package findItinerary;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/8/27 上午10:42
 */
public class Solution2 {
    Map<String, List<String>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets){
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) map.put(ticket.get(0), new ArrayList<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        for (String s : map.keySet()) {
            map.get(s).sort(Comparator.naturalOrder());
        }
        dfs("JFK");
        return res;
    }

    private void  dfs (String airport) {
        List<String> tmp = map.get(airport);
        while (tmp!=null && !tmp.isEmpty()) {
            String nextAirport = tmp.remove(0);
            dfs(nextAirport);
        }
        res.add(0,airport);
    }
}
