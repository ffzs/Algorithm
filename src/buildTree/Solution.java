package buildTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ffzs
 * @describe 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,1,2,15,7]
 * 中序遍历 inorder = [1,9,2,3,15,20,7]
 * 返回如下的二叉树：
 *
 *            3
 *          /   \
 *        9     20
 *       / \   /  \
 *     1   2  15    7
 *
 * 左：root(3) 左边 [1,9,2]  层级关系 [9,1,2] -> root(9)
 *   左： root(9) [1]
 *   右:  root(9) [2]
 * 右：root(3) 右边 [15,20,7] 层级关系 [20,15,7] -> root(20)
 *   左： root(20) [15]
 *   右:  root(20) [7]
 *
 * 对树创造枝叶的时候是通过前序遍历的顺序，通过中序遍历的顺序限制左右树
 *
 * @date 2020/5/22
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    int index = 0;
    int[] inorder;
    int[] preorder;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length-1);
    }
    private TreeNode buildTree(int inorderStart, int inorderEnd){
        if(inorderStart > inorderEnd){
            return null;
        }
        int root = map.get(preorder[index]);
        TreeNode node = new TreeNode(inorder[root]);
        index++;
        node.left = buildTree(inorderStart, root-1);
        node.right = buildTree(root+1, inorderEnd);
        return node;
    }
}
