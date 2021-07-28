## 1104. 二叉树寻路

## 题目

在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。

如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；

而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。



给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。

 

```java
示例 1：

输入：label = 14
输出：[1,3,4,14]
示例 2：

输入：label = 26
输出：[1,2,6,10,26]
```

```java
提示：

1 <= label <= 10^6
```


链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree

## 解题记录

+ 仔细观察该树的每一层的数量其实是2的阶乘，每一层的取值范围`8-15>1000-1111`可以通过二进制进行转化位置
+ 回溯上层位置也可以根据`label >> 1`进行操作

```java
/**
 * @author: ffzs
 * @Date: 2021/7/29 上午7:00
 */
public class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        int r = 1, start = 1;
        while (start * 2 <= label) {
            r ++;
            start *= 2;
        }

        if (r % 2 == 0) label = reverse(label, r);
        List<Integer> res = new ArrayList<>();

        while (r > 0) {
            if (r % 2 == 0) res.add(0, reverse(label, r));
            else res.add(0, label);
            r --;
            label >>= 1;
        }
        return res;
    }

    private int reverse(int label, int r) {
        return (1 << r -1) + (1 << r) - 1 - label;
    }

}
```

![image-20210729071608598](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210729071608598.png)