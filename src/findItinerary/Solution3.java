package findItinerary;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/8/27 上午10:51
 */
public class Solution3 {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets){
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) map.put(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }
        dfs("JFK");
        return res;
    }

    private void  dfs (String airport) {
        PriorityQueue<String> tmp = map.get(airport);
        while (tmp!=null && !tmp.isEmpty()) {
            dfs(tmp.poll());
        }
        res.addFirst(airport);
    }
}
