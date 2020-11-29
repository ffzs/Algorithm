## [976. 三角形的最大周长](https://leetcode-cn.com/problems/largest-perimeter-triangle/)

## 题目

给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。

如果不能形成任何面积不为零的三角形，返回 0。

```java
示例 1：

输入：[2,1,2]
输出：5
示例 2：

输入：[1,2,1]
输出：0
示例 3：

输入：[3,2,3,4]
输出：10
示例 4：

输入：[3,6,2,3]
输出：8
```


提示：

3 <= A.length <= 10000
1 <= A[i] <= 10^6


链接：https://leetcode-cn.com/problems/largest-perimeter-triangle

## 解题记录

+ 优先排序，从大数开始取上个相邻数，如果两个小边之和大于大的那个边，那么这三条边可以组成一个三角形

```java
/**
 * @author: ffzs
 * @Date: 2020/11/29 下午3:33
 */
public class Solution {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i-2] + A[i-1] > A[i]) return A[i-1] + A[i-2] + A[i];
        }
        return 0;
    }
}
```

![image-20201129162431863](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201129162431863.png)