package buildTree2;

/**
 * @author: ffzs
 * @Date: 2020/9/25 上午7:53
 */
public class Solution2 {

    int pi;
    int ii;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pi = postorder.length-1;
        ii = inorder.length-1;
        return buildTree(inorder, postorder, Integer.MAX_VALUE);
    }

    private TreeNode buildTree (int[] inorder, int[] postorder, int mid) {
        if (pi < 0) return null;
        if (inorder[ii] == mid) {
            ii --;
            return null;
        }

        int cur = postorder[pi];
        TreeNode root = new TreeNode(cur);
        pi--;

        root.right = buildTree(inorder, postorder, cur);
        root.left = buildTree(inorder, postorder, mid);
        return root;
    }
}
