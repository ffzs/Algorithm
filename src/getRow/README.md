## [119. 杨辉三角 II](https://leetcode-cn.com/problems/pascals-triangle-ii/)

## 题目

给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

```java
示例:

输入: 3
输出: [1,3,3,1]
```

```java
进阶：
你可以优化你的算法到 O(k) 空间复杂度吗？
```


链接：https://leetcode-cn.com/problems/pascals-triangle-ii

## 解题记录

+ 直接一行一行叠加就可以
+ 用于空间优化可以修改的过程中，通过从后向前叠加

```java
/**
 * @author: ffzs
 * @Date: 2021/2/12 下午1:56
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(0);
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
}
```

![image-20210212152908771](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210212152908771.png)