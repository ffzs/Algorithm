package accountsMerge;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/1/18 下午7:37
 */

class UnionFind {
    private int[] father;

    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) father[i] = i;
    }

    public int find (int i) {
        if (father[i] != i) father[i] = find(father[i]);
        return father[i];
    }

    public void union (int i, int j) {
        father[find(i)] = find(j);
    }
}

public class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> indexMap = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();

        int count = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!indexMap.containsKey(email)) {
                    indexMap.put(email, count++);
                    nameMap.put(email, name);
                }
            }
        }

        UnionFind uni = new UnionFind(count);

        for (List<String> account : accounts) {
            int index1 = indexMap.get(account.get(1));
            for (int i = 2; i < account.size(); i++) {
                int index2 = indexMap.get(account.get(i));
                uni.union(index1, index2);
            }
        }

        Map<Integer, List<String>> map = new HashMap<>();
        for (Map.Entry<String, Integer> entry : indexMap.entrySet()) {
            int index = uni.find(entry.getValue());
            if (!map.containsKey(index)) map.put(index, new ArrayList<>());
            map.get(index).add(entry.getKey());
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : map.values()) {
            Collections.sort(emails);
            List<String> row = new ArrayList<>();
            row.add(nameMap.get(emails.get(0)));
            row.addAll(emails);
            res.add(row);
        }
        return res;
    }
}
