## 863. 二叉树中所有距离为 K 的结点

## 题目

给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。

返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。

 

```java
示例 1：

输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
输出：[7,4,1]
解释：
所求结点为与目标结点（值为 5）距离为 2 的结点，
值分别为 7，4，以及 1

注意，输入的 "root" 和 "target" 实际上是树上的结点。
上面的输入仅仅是对这些对象进行了序列化描述。
```



```java
提示：

给定的树是非空的。
树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
目标结点 target 是树上的结点。
0 <= K <= 1000.
```


链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree

## 解题记录

+ 这个寻找有三个方向，target的左树，右树，以及父节点（及左右树）
+ 也就是说还需要往回找，这个通过构建一个往回查找的hash结构即可

```java
/**
 * @author: ffzs
 * @Date: 2021/7/28 上午6:58
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    List<Integer> res;
    Map<Integer, TreeNode> map;
    int k;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        map = new HashMap<>();
        this.k = k;
        findParents(root);

        dfs(target, null, 0);
        return res;
    }

    private void dfs(TreeNode node, TreeNode pre, int level) {
        if (node == null) return;

        if (level == k) {
            res.add(node.val);
            return;
        }

        if (node.left != pre) dfs(node.left, node, level + 1);
        if (node.right != pre) dfs(node.right, node, level + 1);

        if (map.get(node.val) != pre) dfs(map.get(node.val), node, level+1);

    }

    private void findParents(TreeNode node) {
        if (node.left != null) {
            map.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            map.put(node.right.val, node);
            findParents(node.right);
        }
    }
}
```

![image-20210728071815961](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210728071815961.png)