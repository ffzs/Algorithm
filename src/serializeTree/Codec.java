package serializeTree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/16
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Codec {

    public void serialize(TreeNode root, StringBuilder pre) {
        if (root == null) {
            pre.append("null,");
        }else{
            pre.append(root.val).append(",");
            serialize(root.left, pre);
            serialize(root.right, pre);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder pre = new StringBuilder();
        serialize(root, pre);
        return pre.toString();
    }

    public TreeNode deserialize(Deque<String> stack){
        if (stack.isEmpty() || stack.peek().equals("null")) {
            stack.pop();
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(stack.pop()));
        root.left = deserialize(stack);
        root.right = deserialize(stack);

        return root;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> stack = new LinkedList<String>(Arrays.asList(data.split(",")));
        return deserialize(stack);
    }
}
