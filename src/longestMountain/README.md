## [845. 数组中的最长山脉](https://leetcode-cn.com/problems/longest-mountain-in-array/)

## 题目

我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：

B.length >= 3
存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
（注意：B 可以是 A 的任意子数组，包括整个数组 A。）

给出一个整数数组 A，返回最长 “山脉” 的长度。

如果不含有 “山脉” 则返回 0。

 

```java
示例 1：

输入：[2,1,4,7,3,2,5]
输出：5
解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
```

```java
示例 2：

输入：[2,2,2]
输出：0
解释：不含 “山脉”。
```


提示：

0 <= A.length <= 10000
0 <= A[i] <= 10000


链接：https://leetcode-cn.com/problems/longest-mountain-in-array

## 解题记录

+ 想要形成山脉的话，优先要有上坡和下坡，注意这里的上下坡都是严格要求的递增和递减，相等的不需要
+ 通过while遍历数，优先找上坡，记录长度，再找下坡记录长度，在同时有上坡和下坡的情况下更新max

```java
/**
 * @author: ffzs
 * @Date: 2020/10/25 上午6:13
 */
public class Solution {

    public static int longestMountain(int[] A) {
        int i = 0, max = 0;
        while (i < A.length) {
            int up = 0, down = 0;
            while (i < A.length - 2 && A[i] - A[i + 1] < 0) {
                i++;
                up++;
            }
            while (i + 1 < A.length && A[i + 1] - A[i] < 0) {
                i++;
                down++;
            }
            if (up > 0 && down > 0) max = Math.max(max, up + down + 1);
            if (down > 0 || up > 0) i--;
            i++;
        }
        return max;
    }
}

class Test {
    public static void main(String[] args) {
//        int[] A = {2,1,4,7,3,2,5};
        int[] A = {40, 51, 29, 19, 50, 25};
        System.out.println(Solution.longestMountain(A));
    }
}
```

![image-20201025064715087](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201025064715087.png)