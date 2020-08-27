package findItinerary;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/8/27 上午8:04
 */

public class Solution {
    Map<String, List<String>> map = new HashMap<>();
    boolean flag = false;
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets){
        for (List<String> ticket : tickets) {
            if (map.containsKey(ticket.get(0))) map.get(ticket.get(0)).add(ticket.get(1));
            else {
                map.put(ticket.get(0), new ArrayList<>(List.of(ticket.get(1))));
            }
        }
        for (String s : map.keySet()) {
            map.get(s).sort(Comparator.naturalOrder());
        }
        String airport = "JFK";
        findItinerary(airport, tickets.size(), new ArrayList<>(List.of(airport)));
        return res;
    }

    private void findItinerary (String airport, int times, List<String> list){
        if (times==0 && !flag) {
            res = new ArrayList<>(list); flag = true;
            System.out.println(list);
            return;
        }

        if (map.get(airport)!=null&&!map.get(airport).isEmpty()) {
            List<String> tmp = map.get(airport);
            int size = map.get(airport).size();
            for (int i = 0; i < size; i++) {
                String nextAirport = tmp.remove(0);
                list.add(nextAirport);
                if (times-1 == 4 && airport.equals("JFK") && nextAirport.equals("OOL")) {
                    System.out.println(times-1+"->"+map);
                    System.out.println(tmp);
                }
                if (!flag) findItinerary(nextAirport, times-1, list);
                list.remove(list.size()-1);
                tmp.add(nextAirport);
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        String[][] it = {{"CBR","JFK"},{"TIA","EZE"},{"AUA","TIA"},{"JFK","EZE"},{"BNE","CBR"},{"JFK","CBR"},{"CBR","AUA"},{"EZE","HBA"},{"AXA","ANU"},{"BNE","EZE"},{"AXA","EZE"},{"AUA","ADL"},{"OOL","JFK"},{"BNE","AXA"},{"OOL","EZE"},{"EZE","ADL"},{"TIA","BNE"},{"EZE","TIA"},{"JFK","AUA"},{"AUA","EZE"},{"ANU","ADL"},{"TIA","BNE"},{"EZE","OOL"},{"ANU","BNE"},{"EZE","ANU"},{"ANU","AUA"},{"BNE","ANU"},{"CNS","JFK"},{"TIA","ADL"},{"ADL","AXA"},{"JFK","OOL"},{"AUA","ADL"},{"ADL","TIA"},{"ADL","ANU"},{"ADL","JFK"},{"BNE","EZE"},{"ANU","BNE"},{"JFK","BNE"},{"EZE","AUA"},{"EZE","AXA"},{"AUA","TIA"},{"ADL","CNS"},{"AXA","AUA"}};
        List<List<String>> tickets = new ArrayList<>();
        for (String[] str : it) {
            tickets.add(Arrays.asList(str));
        }
        Solution solution = new Solution();
        System.out.println(solution.findItinerary(tickets));
    }
}
