package shoppingOffers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/10/24 上午7:24
 */
public class Solution {
    Map<List<Integer>, Integer> memo = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        List<List<Integer>> filteredSpecial = new ArrayList<>();
        for (List<Integer> sp : special) {
            int totalPrice = 0;
            boolean flag = true;
            for (int i = 0; i < n && flag; i++) {
                if (sp.get(i) > needs.get(i)) flag = false;
                totalPrice += sp.get(i) * price.get(i);
            }
            if (flag && totalPrice > sp.get(n)) filteredSpecial.add(sp);
        }
        
        return dfs(price, needs, filteredSpecial, n);
    }

    private int dfs(List<Integer> price,  List<Integer> needs, List<List<Integer>> filteredSpecial, int n) {
        if (!memo.containsKey(needs)) {
            int minPrice = 0;
            for (int i = 0; i < n; i++) {
                minPrice += needs.get(i) * price.get(i);
            }

            for (List<Integer> sp : filteredSpecial) {
                int spPrice = sp.get(n);
                List<Integer> subNeeds = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (sp.get(i) > needs.get(i)) break;
                    subNeeds.add(needs.get(i) - sp.get(i));
                }
                if (subNeeds.size() == n) minPrice = Math.min(minPrice, dfs(price, subNeeds, filteredSpecial, n) + spPrice);
            }

            memo.put(needs, minPrice);
        }
        return memo.get(needs);
    }

}
