## [501. 二叉搜索树中的众数](https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/)

## 题目

给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树

```java
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].

提示：如果众数超过1个，不需考虑输出顺序
```

进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree

## 解题记录

+ 因为是二叉搜索树，所以中序遍历是有序的
+ 我们可以通过统计重复值得方法进行统计
+ 记录前一个值，如果相同记录下来，统计重复次数，将次数最大值返回

```java
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
```



![image-20200924081408767](README.assets/image-20200924081408767.png)

## 进阶

+ 使用list也算是多余空间，我们使用list，直接使用数组
+ 可以遍历两次，第一次获取最大统计数，并且获得有最大统计数的数量
+ 第二次遍历将结果写入数组

```java
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
```

![image-20200924082321157](README.assets/image-20200924082321157.png)