package DetectSquares;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/1/26 上午8:11
 * 轴对齐正方形
 */
public class DetectSquares {
    Map<Integer, Map<Integer, Integer>> map;
    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        if (!map.containsKey(y)) map.put(y, new HashMap<>());
        Map<Integer, Integer> subMap = map.get(y);
        subMap.put(x, subMap.getOrDefault(x, 0) + 1);
    }


    public int count(int[] point) {
        int ret = 0;
        int x = point[0], y = point[1];
        if (!map.containsKey(y)) return ret;
        Map<Integer, Integer> subMap = map.get(y);
        for (Map.Entry<Integer, Map<Integer, Integer>> ent : map.entrySet()) {
            int y1 = ent.getKey();
            if (y1 == y) continue;
            Map<Integer, Integer> yCnt = ent.getValue();
            int d = y1 - y;
            ret += yCnt.getOrDefault(x, 0) * subMap.getOrDefault(x - d, 0) * yCnt.getOrDefault(x - d, 0);
            ret += yCnt.getOrDefault(x, 0) * subMap.getOrDefault(x + d, 0) * yCnt.getOrDefault(x + d, 0);
        }
        return ret;
    }

}
