package generateTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/7/21 上午7:43
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

    public static List<TreeNode> generateTrees(int n) {

        if (n == 0) return new ArrayList<>();
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees (int l, int r) {
        List<TreeNode> ret = new ArrayList<>();
        if (l > r) {
            ret.add(null);
            return ret;
        }

        for (int i = l; i <= r ; ++i) {
            for(TreeNode ln: generateTrees(l, i-1)) {
                for(TreeNode rn: generateTrees(i+1, r)) {
                    ret.add(new TreeNode(i, ln, rn));
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(4));
    }
}
