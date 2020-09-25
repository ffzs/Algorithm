package pathSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/26 上午7:05
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int sum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        if (root == null) return res;
        dfs(root, new ArrayList<>(List.of(root.val)), root.val);
        return  res;
    }

    private void dfs (TreeNode root, List<Integer> list, int vals) {
        if (root.left == null && root.right == null && vals == sum ) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
            vals += root.left.val;
            System.out.println(vals);
            dfs(root.left, list, vals);
            list.remove(list.size()-1);
            vals -= root.left.val;
        }
        if (root.right != null) {
            list.add(root.right.val);
            vals += root.right.val;
            dfs(root.right, list, vals);
            list.remove(list.size()-1);
        }
    }
}
