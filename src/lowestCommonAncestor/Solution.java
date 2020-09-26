package lowestCommonAncestor;

/**
 * @author: ffzs
 * @Date: 2020/9/27 上午7:07
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        // 如果pq的都小于val，说明在左边
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 如果pq的值都大于val，说明共同父节点在右边
        else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 如果p，q一个大于一个小于，说明，该节点就是共同父节点
        else {
            return root;
        }
    }
}
