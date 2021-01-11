package smallestStringWithSwaps;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/1/11 下午8:23
 */
public class Solution {
    boolean[] visited;
    List<List<Integer>> lists = new ArrayList<>();
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) return s;
        char[] cs = s.toCharArray();
        int n = cs.length;
        this.visited = new boolean[n];

        Map<Integer, List<Integer>> tmp = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            int x = pairs.get(i).get(0), y = pairs.get(i).get(1);
            if (!tmp.containsKey(x)) tmp.put(x, new ArrayList<>());
            if (!tmp.containsKey(y)) tmp.put(y, new ArrayList<>());
            tmp.get(x).add(y);
            tmp.get(y).add(x);
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                List<Integer> lst = new ArrayList<>();
                dfs(i, tmp, lst);
                lists.add(lst);
            }
        }

        char[] res = new char[n];

        for (List<Integer> list : lists) {
            char[] sub_cs = new char[list.size()];
            int[] is = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                int idx = list.get(i);
                sub_cs[i] = cs[idx];
                is[i] = idx;
            }
            Arrays.sort(sub_cs);
            Arrays.sort(is);
            for (int i = 0; i < is.length; i++) {
                res[is[i]] = sub_cs[i];
            }
        }

        return new String(res);
    }

    private void dfs (int i, Map<Integer, List<Integer>> tmp, List<Integer> lst) {
        if (visited[i]) return;
        else {
            visited[i] = true;
            lst.add(i);
            if (tmp.containsKey(i)) {
                for (int j: tmp.get(i)) {
                    if (!visited[j]) {
                        dfs(j, tmp, lst);
                    }
                }
            }
        }
    }
}

