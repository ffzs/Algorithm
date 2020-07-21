## [95. 不同的二叉搜索树 II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii/)

## 题目

给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

```java
示例：

输入：3
输出：
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释：
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```



```java
提示：

0 <= n <= 8
```


链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii

## 解题记录

+ [Leetcode:NO.96 不同的二叉搜索树 动态规划](https://blog.csdn.net/tonydz0523/article/details/107352161) 逻辑跟这个差不多，都是通过选取根节点的方法获取全部类型
+ 通过使用递归的方法，处理根节点左右的数组
+ 获取到左右节点情况后，再进行排列组合，获取全部情况



```java
/**
 * @author: ffzs
 * @Date: 2020/7/21 上午7:43
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

    public static List<TreeNode> generateTrees(int n) {

        if (n == 0) return new ArrayList<>();
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees (int l, int r) {
        List<TreeNode> ret = new ArrayList<>();
        if (l > r) {
            ret.add(null);
            return ret;
        }

        for (int i = l; i <= r ; ++i) {
            for(TreeNode ln: generateTrees(l, i-1)) {
                for(TreeNode rn: generateTrees(i+1, r)) {
                    ret.add(new TreeNode(i, ln, rn));
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(4));
    }
}

```

![image-20200721091249735](README.assets/image-20200721091249735.png)