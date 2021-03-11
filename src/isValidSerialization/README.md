## [331. 验证二叉树的前序序列化](https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/)

## 题目

序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。

```java
     _9_
    /   \

   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
```

例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。

给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。

每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。

你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。

```java
示例 1:

输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
输出: true
示例 2:

输入: "1,#"
输出: false
示例 3:

输入: "9,#,#,1"
输出: false
```



链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree



## 解题记录

+ 虽然是前序遍历，但是树的结构没有给出，那么#和数字的关系可以多样的
+ 最终子节点节点，后面一定需要两个#作为子节点，也就是说一个每添加一个数值，就会有+2-1个位置产生
+ 每添加一个#就会减少一个位置
+ 如果位置提前为0,那么说明不符合规则

```java
/**
 * @author: ffzs
 * @Date: 2021/3/12 上午7:12
 */
public class Solution {

    public boolean isValidSerialization(String preorder) {
        char[] cs = preorder.toCharArray();
        int n = cs.length;
        int i = 0;
        int pos = 1;

        while (i < n) {
            if (pos == 0) return false;
            switch (cs[i]) {
                case ',':
                    i++;
                    break;
                case '#':
                    pos--;
                    i++;
                    break;
                default:
                    while (i<n && cs[i] != ',') i++;
                    pos++;
            }
        }

        return pos == 0;
    }

}
```

![image-20210312073345959](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210312073345959.png)