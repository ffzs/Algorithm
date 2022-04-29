package construct;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/4/29 上午8:37
 */

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

public class Solution {
    int[][] grid;
    public Node construct(int[][] grid) {
        this.grid = grid;
        return dfs(0,0, grid.length);
    }


    private Node dfs (int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (grid[i][j] != grid[x][y]) {
                    int l = len/2;
                    return new Node(true, false, dfs(x, y, l), dfs(x, y + l, l), dfs(x + l, y, l), dfs(x + l, y + l, l));
                }
            }
        }
        return new Node(grid[x][y] == 1, true);
    }

}
