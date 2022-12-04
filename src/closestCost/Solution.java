package closestCost;

/**
 * @author: ffzs
 * @Date: 2022/12/4 下午6:47
 * 通过dfs 获取0——target范围命中情况，缓存后再循环basecosts
 */
public class Solution {
    int res = Integer.MAX_VALUE, gap = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int baseCost : baseCosts) {
            dfs(toppingCosts, 0, target, baseCost);
        }
        return res;
    }

    private void dfs (int[] toppingCosts, int idx, int target, int total) {
        int v = Math.abs(total - target);
        if (v == gap && total < res) {
            res = total;
        }
        else if (v < gap) {
            res = total;
            gap = v;
        }
        if (idx >= toppingCosts.length) return;
        if (total > target && v > gap) return;
        dfs(toppingCosts, idx + 1, target, total);
        dfs(toppingCosts, idx + 1, target, total + toppingCosts[idx]);
        dfs(toppingCosts, idx + 1, target, total + toppingCosts[idx] * 2);
    }

}
