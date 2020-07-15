## [96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/)

## 题目

给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

```java
示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```




链接：https://leetcode-cn.com/problems/unique-binary-search-trees



## 解题记录

+ 二叉搜索树的特点是前序遍历的话是有序的
+ 我们在构造二叉树的时候可以通过选取root节点的不同做以区别
+ 通过一个列表记录数组长度不同对应的类型数量
+ 直到最终获取数组长度为n时对应的数量，即为结果

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/7/15
 */
public class Solution {
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(numTrees(n));
    }
}

```

![image-20200715085831138](README.assets/image-20200715085831138.png)