package diffWaysToCompute;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/7/1 上午8:17
 */
public class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> items = new ArrayList<>();
        int num = 0;
        for (char c : expression.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num *= 10;
                num += c - '0';
            }
            else {
                items.add(num);
                num = 0;
                items.add(-(int)c);
            }
        }
        items.add(num);
        Integer[] its = items.toArray(new Integer[0]);
        List<Integer>[][] dp = new List[its.length][its.length];
        for (int i = 0; i < its.length; i++) {
            for (int j = 0; j < its.length; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        return dfs(dp, 0, its.length-1, its);
    }

    private List<Integer> dfs (List<Integer>[][] dp, int l, int r, Integer[] its) {
        if (dp[l][r].isEmpty()) {
            if (l == r) {
                dp[l][r].add(its[l]);
            }
            else {
                for (int i = l; i < r; i+=2) {
                    List<Integer> left = dfs(dp, l, i, its);
                    List<Integer> right = dfs(dp, i+2, r, its);
                    for (int ll : left) {
                        for (int rr : right) {
                            if (its[i + 1] == -(int)'+') {
                                dp[l][r].add(ll + rr);
                            }
                            else if (its[i + 1] == -(int)'-') {
                                dp[l][r].add(ll - rr);
                            }
                            else {
                                dp[l][r].add(ll * rr);
                            }
                        }

                    }
                }
            }

        }
        return dp[l][r];
    }

}
