## [118. 杨辉三角](https://leetcode-cn.com/problems/pascals-triangle/)

## 题目

给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

```java
示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```


链接：https://leetcode-cn.com/problems/pascals-triangle

## 解题记录

+ 通过构建上一层的情况来构建下一层

```java
/**
 * @author: ffzs
 * @Date: 2020/12/6 下午12:47
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        List<Integer> pre = new ArrayList<>(List.of(1));
        res.add(pre);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>(pre.size()+1);
            cur.add(1);
            for (int j = 1; j < pre.size(); j++) {
                cur.add(pre.get(j-1)+pre.get(j));
            }
            cur.add(1);
            res.add(cur);
            pre = cur;
        }
        return res;
    }
}
```

![image-20201206130847005](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201206130847005.png)