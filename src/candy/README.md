## [135. 分发糖果](https://leetcode-cn.com/problems/candy/)

## 题目

老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

你需要按照以下要求，帮助老师给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

```java
示例 1:

输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
示例 2:

输入: [1,2,2]
输出: 4
解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
```


链接：https://leetcode-cn.com/problems/candy

## 解题记录

+ 优先从左到右分配一次，如果右边的比左边的大那么右边的为左边+1
+ 同时也要满足从右到左的情况，如果左边比右边的大那么右边的基础上再+1
+ 然后选取左右两个顺序中比较大的



```java
/**
 * @author: ffzs
 * @Date: 2020/12/24 下午7:22
 */
public class Solution {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n], right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < left.length; i++) {
            if (ratings[i] > ratings[i-1]) left[i] = left[i-1] + 1;
        }

        for (int i = right.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) right[i] = right[i+1] + 1;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.max(left[i], right[i]);
        }

        return res;
    }
}
```

![image-20201224200043972](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201224200043972.png)