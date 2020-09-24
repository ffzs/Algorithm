package findMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/24 上午7:29
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int pre;
    int times = 0;
    int max = 0;
    boolean start = true;
    List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        dfs(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dfs (TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (start) {
            pre = root.val;
            start = false;
        }
        if (root.val == pre) {
            times ++;
        }
        else {
            pre = root.val;
            times = 1;
        }
        if (times == max) {
            res.add(root.val);
        }
        else if (times > max){
            res.clear();
            res.add(root.val);
            max = times;
        }
        dfs(root.right);
    }
}

class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findMode(root)));
    }
}
