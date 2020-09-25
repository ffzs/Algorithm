package findMode;


/**
 * @author: ffzs
 * @Date: 2020/9/24 上午8:15
 */
public class Solution2 {
    int pre;
    int times = 0;
    int max = 0;
    int maxCount = 0;
    int index = 0;
    boolean start = true;
    int[] res;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        dfs(root , -1);
        res = new int[maxCount];
        times = 0;
        dfs(root, max);
        return res;
    }

    private void dfs (TreeNode root, int aimTimes) {
        if (root == null) return;
        dfs(root.left, aimTimes);
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
        if (times == aimTimes) {
            res[index] = root.val;
            index++;
        }
        if (times == max) {
            maxCount ++;
        }
        else if (times > max){
            maxCount = 1;
            max = times;
        }
        dfs(root.right, aimTimes);
    }
}
