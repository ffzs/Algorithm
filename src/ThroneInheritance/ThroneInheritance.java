package ThroneInheritance;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/6/20 上午9:13
 */

public class ThroneInheritance {
    Map<String, List<String>> inheritance = new HashMap<>();
    Set<String> dead = new HashSet<>();
    String kingName;
    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
    }

    public void birth(String parentName, String childName) {
        if (!inheritance.containsKey(parentName)) inheritance.put(parentName, new ArrayList<>());
        inheritance.get(parentName).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(res, kingName);
        return res;
    }

    private void dfs(List<String> res, String name){
        if (!dead.contains(name)) res.add(name);
        if (inheritance.containsKey(name)) {
            List<String> children = inheritance.get(name);
            for (String child : children) {
                dfs(res, child);
            }
        }
    }

}
