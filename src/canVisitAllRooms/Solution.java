package canVisitAllRooms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/8/31 上午7:54
 */
public class Solution {

    boolean flag = true;
    List<List<Integer>> map;
    boolean[] in;
    int count;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.map = rooms;
        this.in = new boolean[rooms.size()];
        this.count = rooms.size();
        canVisitAllRooms(0, rooms.size()-1);
        return !flag;
    }

    private void canVisitAllRooms (int room, int times){
        if (flag) {
            if (!in[room]) {
                in[room] = true;
                if (--count == 0){
                    flag = false;
                    return;
                }
            }
            if (map.get(room)!=null&&!map.get(room).isEmpty()) {
                List<Integer> tmp = map.get(room);
                int size = map.get(room).size();
                for (int i = 0; i < size; i++) {
                    Integer nextRoom = tmp.remove(i);
                    canVisitAllRooms(nextRoom, times-1);
                    tmp.add(i,nextRoom);
                }
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(List.of(1)));
        rooms.add(new ArrayList<>(List.of(2)));
        rooms.add(new ArrayList<>(List.of(3)));
        rooms.add(new ArrayList<>());
        System.out.println(solution.canVisitAllRooms(rooms));
    }
}