package pathSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/26 上午7:36
 */
public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, new ArrayList<>(), sum);
        return res;
    }

    private void dfs (TreeNode root, List<Integer> list, int sum) {
        if (root == null) return;

        sum -= root.val;
        list.add(root.val);
        if (sum == 0 && root.right == null && root.left == null) {
            res.add(new ArrayList<>(list));
        }

        dfs(root.left, list, sum);
        dfs(root.right, list, sum);

        list.remove(list.size()-1);
    }
}
