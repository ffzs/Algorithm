package getImportance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/5/1 上午9:22
 */
public class Solution2 {
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        return dfs(id);
    }

    private int dfs(int id) {

        Employee cur = map.get(id);

        for (int i : cur.subordinates) {
            cur.importance += dfs(i);
        }

        return cur.importance;
    }

}
