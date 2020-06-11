package levelOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class levelOrder {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
    // 优先遍历深度 dps
        if(root!=null) dps(0, root);
        return res;
    }

    void dps (int level, TreeNode n){
        if (res.size()==level) res.add(new ArrayList<>());
        res.get(level).add(n.val);
        if(n.left!=null) dps(level+1, n.left);
        if(n.right!=null) dps(level+1, n.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}