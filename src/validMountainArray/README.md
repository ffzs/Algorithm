## [941. 有效的山脉数组](https://leetcode-cn.com/problems/valid-mountain-array/)

## 题目

给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。

让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：

A.length >= 3
在 0 < i < A.length - 1 条件下，存在 i 使得：
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]



![image-20201103063148308](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201103063148308.png)

```java


示例 1：

输入：[2,1]
输出：false
示例 2：

输入：[3,5,5]
输出：false
示例 3：

输入：[0,3,2,1]
输出：true
```


提示：

0 <= A.length <= 10000
0 <= A[i] <= 10000 

链接：https://leetcode-cn.com/problems/valid-mountain-array


## 解题记录

+ 根据题意，优先查找升序，如果出现降序进入下一阶段，如果相同直接返回false
+ 进入判断降序之前先判断是否没有升序，或是没有降序`i == A.length -1 || i==0`如果是的话直接false
+ 然后是判断降序

```java
/**
 * @author: ffzs
 * @Date: 2020/11/3 上午6:18
 */
public class Solution {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int i = 0;
        while (i+1 < A.length) {
            if (A[i+1] < A[i]) break;
            else if (A[i+1] == A[i]) return false;
            i++;
        }
        if (i == A.length -1 || i==0) return false;
        while (i+1 < A.length) {
            if (A[i+1] >= A[i]) return false;
            i++;
        }
        return true;
    }

}
```

![image-20201103063445109](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201103063445109.png)