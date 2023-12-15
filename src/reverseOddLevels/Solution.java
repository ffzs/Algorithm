package reverseOddLevels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/12/15 上午10:55
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public TreeNode reverseOddLevels(TreeNode root) {
        int level = 0;
        List<TreeNode> lst = new ArrayList<>();
        List<TreeNode> tmp = new ArrayList<>();

        lst.add(root);

        while (!lst.isEmpty()) {
            if (level % 2 == 1) {
                int l = 0, r = lst.size()-1;
                while (l < r) {
                    int t = lst.get(l).val;
                    lst.get(l).val = lst.get(r).val;
                    lst.get(r).val = t;
                    l++;
                    r--;
                }
            }
            for (TreeNode treeNode : lst) {
                if (treeNode.left == null) break;
                tmp.add(treeNode.left);
                tmp.add(treeNode.right);
            }
            lst = new ArrayList<>(tmp);
            tmp.clear();
            level++;
        }
        return root;
    }

}
