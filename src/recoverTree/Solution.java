package recoverTree;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/8/8 上午8:26
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

    List<Integer> values;
    int index = 0;
    public void recoverTree(TreeNode root) {
        values = new ArrayList<>();
        getValue(root);
        values.sort(Comparator.naturalOrder());
        changeValue(root);
    }

    private void getValue (TreeNode root) {
        if (root != null) {
            getValue(root.left);
            values.add(root.val);
            getValue(root.right);
        }
    }

    private void changeValue (TreeNode root) {
        if (root != null) {
            changeValue(root.left);

            if (root.val != values.get(index)){
                root.val = values.get(index);
            }
            index ++;

            changeValue(root.right);
        }
    }
}
