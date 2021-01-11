package smallestStringWithSwaps;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/1/11 下午8:41
 */
public class Solution2 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] father = new int[n];

        for (int i = 0; i < n; i++) {
            father[i] = i;
        }

        for (List<Integer> p : pairs) {
            merge(p.get(0), p.get(1), father);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int f = find(i, father);
            if (!map.containsKey(f)) map.put(f, new ArrayList<>());
            map.get(f).add(i);
        }

        char[] res = new char[n];
        for (List<Integer> value : map.values()) {
            char[] tmp = new char[value.size()];
            for (int i = 0; i < value.size(); i++) {
                tmp[i] = s.charAt(value.get(i));
            }

            Arrays.sort(tmp);

            for (int i = 0; i < value.size(); i++) {
                res[value.get(i)] = tmp[i];
            }
        }

        return new String(res);
    }

    private int find(int i, int[] father) {
        if (father[i] != i) father[i] = find(father[i], father);
        return father[i];
    }

    private void merge(int i, int j, int[] father) {
        father[find(i, father)] = find(j, father);
    }
}
