package sortedArrayToBST;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/3
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums,0, nums.length-1);
    }

    private TreeNode makeTree (int[] nums, int left, int right) {
        if (left == right) return new TreeNode(nums[left]);
        if (left > right) return null;

        int mid = left + right + 1 >> 1;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeTree(nums, left, mid-1);
        root.right = makeTree(nums, mid+1, right);
        return root;
    }
}
