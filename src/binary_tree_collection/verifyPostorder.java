package binary_tree_collection;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/5
 */
public class verifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length-1);
    }

    public boolean check (int[] pos, int start, int end) {
        if (end - start <= 1) return true;
        int root = start;
        while (pos[root] < pos[end]) root++;
        int m = root;
        while (pos[root] > pos[end]) root++;
        return root==end && check(pos, start, m-1) && check(pos, m, end -1);
    }
}
