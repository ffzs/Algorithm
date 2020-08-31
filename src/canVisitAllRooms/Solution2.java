package canVisitAllRooms;

import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/8/31 上午8:21
 */
public class Solution2 {

    List<List<Integer>> map;
    int count = 0;
    boolean[] in;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        map = rooms;
        in = new boolean[rooms.size()];
        dfs(0);
        return count==rooms.size();
    }

    private void  dfs (int room) {
        List<Integer> tmp = map.get(room);
        while (tmp!=null && !tmp.isEmpty()) {
            Integer nextAirport = tmp.remove(0);
            dfs(nextAirport);
        }
        if (!in[room]) {
            in[room] = true;
            count++;
        }
    }
}
