package buildTree2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2020/9/25 上午7:23
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int[] inorder;
    int[] postorder;
    int index;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.index = postorder.length-1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, postorder.length-1);
    }

    private TreeNode buildTree (int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(postorder[index]);
        int cur = map.get(postorder[index]);
        index--;
        root.right = buildTree(cur+1, end);
        root.left = buildTree(start, cur-1);
        return root;
    }
}

