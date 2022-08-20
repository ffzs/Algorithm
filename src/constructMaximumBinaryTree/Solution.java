package constructMaximumBinaryTree;

/**
 * @author: ffzs
 * @Date: 2022/8/20 上午8:55
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs (int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);

        int maxVal = nums[l], idx = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                idx = i;
            }
        }

        TreeNode ret = new TreeNode(nums[idx]);
        ret.left = dfs(nums, l, idx - 1);
        ret.right = dfs(nums, idx + 1, r);
        return ret;
    }

}
