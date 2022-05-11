package Codec;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2022/5/11 下午12:08
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString().substring(0, sb.length()-1);
    }

    private void dfs (TreeNode node, StringBuilder sb) {
        if (node == null) return;

        sb.append(node.val).append(',');
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] ss = data.split(",");
        return deDfs(0, ss.length - 1, ss);
    }

    TreeNode deDfs (int l, int r, String[] ss) {
        if (l > r) return null;
        int i = l + 1, val = Integer.parseInt(ss[l]);
        TreeNode node = new TreeNode(val);
        while (i <= r && Integer.parseInt(ss[i]) <= val) ++i;
        node.left = deDfs(l + 1, i - 1, ss);
        node.right = deDfs(i, r, ss);
        return node;
    }

}
