package getImportance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/5/1 上午8:39
 */

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class Solution {
    Map<Integer, List<Integer>> sub = new HashMap<>();
    Map<Integer, Integer> imp = new HashMap<>();
    int res = 0;
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            sub.put(employee.id, employee.subordinates);
            imp.put(employee.id, employee.importance);
        }
        dfs(id);
        return res;
    }

    private void dfs (int id) {
        if (!sub.containsKey(id)) return;
        res += imp.get(id);
        for (int i : sub.get(id)) {
            dfs(i);
        }
    }

}
