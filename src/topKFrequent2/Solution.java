package topKFrequent2;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/5/20 上午7:42
 */
public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        var list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) return b.getValue() - a.getValue();
            else return a.getKey().compareTo(b.getKey());
        });

        System.out.println(list);
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }

        return res;
    }

}
