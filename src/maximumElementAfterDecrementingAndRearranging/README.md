## 1846. 减小和重新排列数组后的最大元素

## 题目

给你一个正整数数组 arr 。请你对 arr 执行一些操作（也可以不进行任何操作），使得数组满足以下条件：

arr 中 第一个 元素必须为 1 。
任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
你可以执行以下 2 种操作任意次：

减小 arr 中任意元素的值，使其变为一个 更小的正整数 。
重新排列 arr 中的元素，你可以以任意顺序重新排列。
请你返回执行以上操作后，在满足前文所述的条件下，arr 中可能的 最大值 。

 

```java
示例 1：

输入：arr = [2,2,1,2,1]
输出：2
解释：
我们可以重新排列 arr 得到 [1,2,2,2,1] ，该数组满足所有条件。
arr 中最大元素为 2 。
示例 2：

输入：arr = [100,1,1000]
输出：3
解释：
一个可行的方案如下：

1. 重新排列 arr 得到 [1,100,1000] 。
2. 将第二个元素减小为 2 。
3. 将第三个元素减小为 3 。
   现在 arr = [1,2,3] ，满足所有条件。
   arr 中最大元素为 3 。
   示例 3：

输入：arr = [1,2,3,4,5]
输出：5
解释：数组已经满足所有条件，最大元素为 5 。
```



```java
提示：

1 <= arr.length <= 105
1 <= arr[i] <= 109
```


链接：https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging

## 解题记录

+ 题目中的逻辑比较隐晦，首先最小值为1，之后可能加一或是不变
+ 最后最大只可能是小于等于n的值
+ 这里通过计数统计小于n的值得个数，大于n的直接放大一起不做处理
+ 然后看小于n的情况中的最大值

```java
/**
 * @author: ffzs
 * @Date: 2021/7/15 上午7:00
 */
public class Solution {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] counter = new int[n+1];

        for (int i : arr) counter[Math.min(i, n)]++;

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res + counter[i], i);
        }
        return res;

    }
}
```

![image-20210715074224957](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210715074224957.png)